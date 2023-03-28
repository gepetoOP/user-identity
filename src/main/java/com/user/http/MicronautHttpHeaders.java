package com.user.http;

import io.micronaut.http.MutableHttpHeaders;
import org.http.HttpHeaders;

import java.util.Optional;

public class MicronautHttpHeaders implements HttpHeaders {
    private final MutableHttpHeaders delegate;

    public MicronautHttpHeaders(MutableHttpHeaders mutableHttpHeaders) {
        this.delegate = mutableHttpHeaders;
    }

    @Override
    public void add(String headerName, String value) {
        delegate.add(headerName, value);
    }

    @Override
    public Optional<String> find(String headerName) {
        return Optional.ofNullable(delegate.get(headerName));
    }

    @Override
    public String findOrNull(String headerName) {
        return delegate.get(headerName);
    }
}
