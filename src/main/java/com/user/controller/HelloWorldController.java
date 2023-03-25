package com.user.controller;

import com.user.async.ExecutorServiceWithContext;
import com.user.service.PaymentsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloWorldController {
    private final ExecutorServiceWithContext executorServiceWithContext;
    private final PaymentsService paymentsService;

    @Get("/hello")
    public String hello() {
        paymentsService.execute();
        executorServiceWithContext.executeAsync(paymentsService::execute);

        return "Teste";
    }
}
