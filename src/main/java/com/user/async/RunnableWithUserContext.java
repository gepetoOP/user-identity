package com.user.async;

import org.context.UserIdentityContext;

public class RunnableWithUserContext implements Runnable {
    @Override
    public void run() {
        var userIdentity = UserIdentityContext.get();
    }
}
