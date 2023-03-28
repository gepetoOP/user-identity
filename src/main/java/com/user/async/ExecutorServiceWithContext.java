package com.user.async;

import jakarta.inject.Singleton;
import org.context.UserIdentityContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Singleton
public class ExecutorServiceWithContext {
    private final ExecutorService executor = Executors.newFixedThreadPool(1);

    public void executeAsync(Runnable runnable) {
        var actualContext = UserIdentityContext.get();

        executor.submit(() -> {
            UserIdentityContext.set(actualContext);

            try {
                runnable.run();
            }
            finally {
                UserIdentityContext.clean();
            }
        });
    }
}
