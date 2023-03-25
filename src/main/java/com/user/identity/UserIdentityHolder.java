package com.user.identity;

import com.user.context.UserIdentityContext;
import jakarta.inject.Singleton;

@Singleton
public class UserIdentityHolder {
    public UserIdentity getUserIdentity() {
        return UserIdentityContext.get();
    }
}
