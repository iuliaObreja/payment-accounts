package org.example.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class PaymentAccountsServiceConfiguration {
//    @Bean
    public PaymentAccountsService employeeService() {
        return new PaymentAccountsServiceImpl();
    }
}
