package com.lukasz2.SpringBootEcomLearnApp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DefaultPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("DefaultPaymentService");

    }
}
