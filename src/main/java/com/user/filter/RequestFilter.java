package com.user.filter;

import com.user.context.UserIdentityContext;
import com.user.identity.UserIdentityBuilder;
import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Filter(Filter.MATCH_ALL_PATTERN)
@Singleton
@RequiredArgsConstructor
public class RequestFilter implements HttpServerFilter, Ordered {
    private final UserIdentityBuilder userIdentityBuilder;

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        var userIdentity = userIdentityBuilder.buildFrom(request);

        UserIdentityContext.set(userIdentity);

        return Flux.from(chain.proceed(request))
                .doOnTerminate(this::cleanContextAndAssertCleanContext);
    }

    private void cleanContextAndAssertCleanContext() {
        UserIdentityContext.clean();

        if (UserIdentityContext.get() != null) {
            throw new RuntimeException("ai c ta de meme");
        }
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
