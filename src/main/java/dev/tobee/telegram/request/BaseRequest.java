package dev.tobee.telegram.request;

import java.net.URI;

public class BaseRequest {

    private final String method;

    private final String host;

    private final String token;

    public BaseRequest(String method, String host, String token) {
        this.method = method;
        this.host = host;
        this.token = token;
    }

    protected URI buildUri() {
        return URI.create(host + "/" + token + "/" + method);
    }
}
