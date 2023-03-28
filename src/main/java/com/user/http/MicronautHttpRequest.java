package com.user.http;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpHeaders;
import org.http.HttpHeaders;
import org.http.Method;

public class MicronautHttpRequest implements org.http.HttpRequest {
    private final HttpRequest<?> requestDelegate;
    private final MicronautHttpHeaders headersDelegate;

    public MicronautHttpRequest(HttpRequest<?> request) {
        this.requestDelegate = request;
        this.headersDelegate = new MicronautHttpHeaders((MutableHttpHeaders) request.getHeaders());
    }

    @Override
    public Method getMethod() {
        return null;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headersDelegate;
    }
}
