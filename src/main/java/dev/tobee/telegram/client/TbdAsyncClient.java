package dev.tobee.telegram.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import dev.tobee.telegram.model.media.FileEntity;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record TbdAsyncClient(boolean isDebugEnabled, String host, String token) {
    private static final Logger logger = LoggerFactory.getLogger(TbdAsyncClient.class);

    private static final DefaultJsonMapper mapper = new DefaultJsonMapper();

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);
    private static final String DEFAULT_MIME_TYPE = "application/json";

    public <T> CompletableFuture<T> getRequest(Request<T> request) {
        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());
        logger.debug("Request to {}", uri);
        return HttpClient.newHttpClient().sendAsync(
                        HttpRequest.newBuilder()
                                .header("Content-Type", DEFAULT_MIME_TYPE)
                                .headers("Accept", DEFAULT_MIME_TYPE)
                                .timeout(DEFAULT_TIMEOUT)
                                .uri(uri)
                                .build(),
                        HttpResponse.BodyHandlers.ofString()
                )
                .thenApplyAsync(this::logResponse)
                .thenApply(HttpResponse::body)
                .thenApply(body -> mapper.parseResponse(body, request.getResponseType()));
    }

    public <T> CompletableFuture<T> postRequest(Request<T> request) {
        String boundary = UUID.randomUUID().toString();
        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());
        return HttpClient.newHttpClient().sendAsync(
                        HttpRequest.newBuilder()
                                .header("Content-Type", "multipart/form-data; charset=utf-8; boundary=" + boundary)
                                .uri(uri)
                                .timeout(DEFAULT_TIMEOUT)
                                .POST(prepareMultipartData(request.getBody().orElseThrow(), boundary))
                                .build(),
                        HttpResponse.BodyHandlers.ofString()
                )
                .thenApplyAsync(this::logResponse)
                .thenApply(HttpResponse::body)
                .thenApply(body -> mapper.parseResponse(body, request.getResponseType()));
    }

    private HttpRequest.BodyPublisher prepareMultipartData(Map<Object, Object> data, String boundary) {
        var byteArrays = new ArrayList<byte[]>();
        byte[] separator =
                ("--" + boundary + "\r\nContent-Disposition: form-data; name=").getBytes(StandardCharsets.UTF_8);
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (entry.getValue() != null) {
                byteArrays.add(separator);
                if (entry.getValue() instanceof LinkedHashMap && ((LinkedHashMap<?, ?>) entry.getValue()).containsKey("file_name")) {
                    var file = DefaultObjectMapper.getMapper().convertValue(entry.getValue(), FileEntity.class);
                    byteArrays.add(("\"" + entry.getKey() + "\"; filename=\""
                            + file.getFileName() + "\"\r\nContent-Type: " + file.getMimeType()
                            + "\r\n\r\n").getBytes(StandardCharsets.UTF_8));
                    byteArrays.add(file.getContent());
                    byteArrays.add("\r\n".getBytes(StandardCharsets.UTF_8));
                } else {
                    byteArrays.add(("\"" + entry.getKey() + "\"\r\n\r\n" + entry.getValue() + "\r\n").getBytes(StandardCharsets.UTF_8));
                }
            }
        }
        byteArrays.add(("--" + boundary + "--").getBytes(StandardCharsets.UTF_8));
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
        logger.debug("Multipart request data \n{}", data);
    }

    private HttpResponse<String> logResponse(HttpResponse<String> response) {
        if (logger.isDebugEnabled() && Objects.nonNull(response.body())) {
            logger.debug("Response {}", response.body());
        }
        return response;
    }
}
