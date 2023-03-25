package com.user.identity;

import io.micronaut.http.HttpRequest;
import jakarta.inject.Singleton;

@Singleton
public class UserIdentityBuilder {
    public UserIdentity buildFrom(HttpRequest<?> request) {
        var headers = request.getHeaders();

        return UserIdentity
                .builder()
                .bankAccount(headers.get("bank-account"))
                .socialId(headers.get("social-id"))
                .name(headers.get("name"))
                .phone(headers.get("phone"))
                .build();
    }
}
