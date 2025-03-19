package com.lukasz2.SpringBootEcomLearnApp.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final PaymentService paymentService;

    @Autowired
    public CheckoutService(
            //@Qualifier("creditCardService")  //if now @Primary than Qualifier need to be used
            PaymentService paymentService) {
        this.paymentService = paymentService;
    }
@PostConstruct
public void init(){
    System.out.println(paymentService.getClass());
}
    public void checkoutOrder(double amount) {

        paymentService.processPayment(amount);
        System.out.println("checkout order for amount: " + amount);
    }
}
