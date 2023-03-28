package com.user.service;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.user.identity.UserIdentityHolder;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class PaymentsService {
    private final UserIdentityHolder userIdentityHolder;

    public void execute() {
        log.info("Salve testes. Context: {}", userIdentityHolder.getUserIdentity());
    }
}
