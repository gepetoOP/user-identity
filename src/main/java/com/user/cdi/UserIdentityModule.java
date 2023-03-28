package com.user.cdi;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.user.identity.UserIdentityBuilder;
import org.user.identity.UserIdentityHolder;

@Factory
public class UserIdentityModule {
    @Bean
    @Singleton
    public UserIdentityBuilder userIdentityBuilder() {
        return new UserIdentityBuilder();
    }

    @Bean
    @Singleton
    public UserIdentityHolder userIdentityHolder() {
        return new UserIdentityHolder();
    }
}
