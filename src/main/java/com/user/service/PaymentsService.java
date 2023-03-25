package com.user.service;

import com.user.identity.UserIdentityHolder;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class PaymentsService {
    private final UserIdentityHolder userIdentityHolder;

    public void execute() {
        log.info("Salve testes. Context: {}", userIdentityHolder.getUserIdentity());
    }
}
