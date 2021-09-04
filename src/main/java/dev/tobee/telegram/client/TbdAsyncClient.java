package dev.tobee.telegram.client;

import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.util.DefaultJsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class TbdAsyncClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TbdAsyncClient.class);

    private static final DefaultJsonMapper mapper = new DefaultJsonMapper();

    private static final String DEFAULT_MIME_TYPE = "application/json";

    private final boolean isDebugEnabled;

    private final String host;

    private final String token;

    public TbdAsyncClient(boolean isDebugEnabled, String host, String token) {
        this.isDebugEnabled = isDebugEnabled;
        this.host = host;
        this.token = token;
    }

    public <T> CompletableFuture<T> getRequest(Request<T> request) {

        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());

        LOGGER.debug("Request to {}", uri);

        return HttpClient.newHttpClient().sendAsync(
                        HttpRequest.newBuilder()
                                .header("Content-Type", DEFAULT_MIME_TYPE)
                                .headers("Accept", DEFAULT_MIME_TYPE)
                                .timeout(Duration.ofSeconds(5))
                                .uri(uri)
                                .build(),
                        HttpResponse.BodyHandlers.ofString()
                )
                .thenApply(HttpResponse::body)
                .thenApply(body -> mapper.parseResponse(body, request.getResponseType()));
    }

    public <T> CompletableFuture<T> postRequest(Request<T> request) {

        String boundary = UUID.randomUUID().toString();

        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());

        return HttpClient.newHttpClient().sendAsync(
                        HttpRequest.newBuilder()
                                .header("Content-Type", "multipart/form-data; charset=utf-8; " +
                                        "boundary=" + boundary)
                                .uri(uri)
                                .timeout(Duration.ofSeconds(1))
                                .POST(prepareMultipartData(request.body().orElseThrow(), boundary))
                                .build(),
                        HttpResponse.BodyHandlers.ofString()
                )
                .thenApplyAsync(this::logingResponse)
                .thenApply(HttpResponse::body)
                .thenApply(body -> mapper.parseResponse(body, request.getResponseType()));
    }

    private HttpRequest.BodyPublisher prepareMultipartData(Map<Object, Object> data, String boundary) {
        var byteArrays = new ArrayList<byte[]>();
        try {
            byte[] separator = ("--" + boundary
                    + "\r\nContent-Disposition: form-data; name=")
                    .getBytes(StandardCharsets.UTF_8);
            for (Map.Entry<Object, Object> entry : data.entrySet()) {
                if (entry.getValue() != null) {
                    byteArrays.add(separator);

                    if (entry.getValue() instanceof Path path) {
                        String mimeType = Files.probeContentType(path);
                        byteArrays.add(("\"" + entry.getKey() + "\"; filename=\""
                                + path.getFileName() + "\"\r\nContent-Type: " + mimeType
                                + "\r\n\r\n").getBytes(StandardCharsets.UTF_8));
                        byteArrays.add(Files.readAllBytes(path));
                        byteArrays.add("\r\n".getBytes(StandardCharsets.UTF_8));
                    } else {

                        byteArrays.add(
                                ("\"" + entry.getKey() + "\"\r\n\r\n" + entry.getValue()
                                        + "\r\n").getBytes(StandardCharsets.UTF_8));
                    }
                }
            }
            byteArrays.add(("--" + boundary + "--").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("Error on generate multipart object", e);
        }

        if (this.isDebugEnabled) {
            printDebugMultipartData(byteArrays);
        }

        return HttpRequest.BodyPublishers.ofByteArrays(byteArrays);
    }

    private void printDebugMultipartData(ArrayList<byte[]> byteArrays) {
        byte[] all = new byte[byteArrays.stream().mapToInt(a -> a.length).sum()];
        int pos = 0;
        for (byte[] bin : byteArrays) {
            int length = bin.length;
            System.arraycopy(bin, 0, all, pos, length);
            pos += length;
        }

        String data = new String(all);

        LOGGER.debug("Multipart request data \n{}", data);
    }

    private HttpResponse<String> logingResponse(HttpResponse<String> response) {
        LOGGER.debug("Response {}", response.body());
        return response;
    }
}