package dev.tobee.telegram.client;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.FileEntity;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public record TelegramApiClient(boolean isDebugEnabled, String host, String token,
                                Optional<URL> outputDumpDirectory) {
    private static final Logger logger = LoggerFactory.getLogger(TelegramApiClient.class);
    private static final DefaultJsonMapper MAPPER = new DefaultJsonMapper();
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);
    private static final String DEFAULT_MIME_TYPE = "application/json";

    public <T> CompletableFuture<T> getRequest(Request<T> request) {
        StringBuilder urlBuilder = new StringBuilder(host)
                .append("/")
                .append(token)
                .append("/")
                .append(request.getMethod());
        if (!request.getQueryParams().isEmpty()) {
            urlBuilder.append("?");
            request.getQueryParams().forEach((key, value) ->
                    urlBuilder.append("&").append(key).append("=").append(value)
            );
        }
        URI uri = URI.create(urlBuilder.toString());
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
                         .thenApply(body -> {
                             outputDumpDirectory.ifPresent(dir -> this.dumpResponseToFile(dir, request.getMethod(), body, request.getResponseType()));
                             return body;
                         })
                         .thenApply(body -> MAPPER.parseResponse(body, request.getResponseType()));
    }

    public <T> T getRequestSync(Request<T> request) throws IOException, InterruptedException {
        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());
        logger.debug("Request to {}", uri);

        var requestObj = HttpRequest.newBuilder()
                                    .header("Content-Type", DEFAULT_MIME_TYPE)
                                    .headers("Accept", DEFAULT_MIME_TYPE)
                                    .timeout(DEFAULT_TIMEOUT)
                                    .uri(uri)
                                    .build();

        var response = HttpClient.newHttpClient().send(requestObj, HttpResponse.BodyHandlers.ofString());
        logResponse(response);
        outputDumpDirectory.ifPresent(dir -> this.dumpResponseToFile(dir, request.getMethod(), response.body(), request.getResponseType()));
        return MAPPER.parseResponse(response.body(), request.getResponseType());
    }

    public <T> CompletableFuture<T> postRequest(Request<T> request) {
        String boundary = UUID.randomUUID().toString();
        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());
        return HttpClient.newHttpClient()
                         .sendAsync(
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
                         .thenApply(body -> {
                             outputDumpDirectory.ifPresent(dir -> this.dumpResponseToFile(dir, request.getMethod(), body, request.getResponseType()));
                             return body;
                         })
                         .thenApply(body -> MAPPER.parseResponse(body, request.getResponseType()));
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

    private void dumpResponseToFile(URL directory, String method, String responseBody, TypeReference<?> reference) {
        try (FileOutputStream ous = new FileOutputStream(Paths.get(directory.getPath(), method + ".json").toFile())) {
            var mapper = DefaultJsonMapper.getMapper();
            var value = mapper.readValue(responseBody, reference);
            var resp = mapper.writeValueAsBytes(value);
            ous.write(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
