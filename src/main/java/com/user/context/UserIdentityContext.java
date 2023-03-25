package com.user.context;

import com.user.identity.UserIdentity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserIdentityContext {
    private static final ThreadLocal<UserIdentity> USER_IDENTITY = new ThreadLocal<>();

    public void set(UserIdentity userIdentity) {
        USER_IDENTITY.set(userIdentity);
    }

    public UserIdentity get() {
        return USER_IDENTITY.get();
    }

    public void clean() {
        USER_IDENTITY.remove();
    }
}
