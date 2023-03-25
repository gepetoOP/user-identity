package com.user.async;

import com.user.context.UserIdentityContext;

public class RunnableWithUserContext implements Runnable {
    @Override
    public void run() {
        var userIdentity = UserIdentityContext.get();
    }
}
