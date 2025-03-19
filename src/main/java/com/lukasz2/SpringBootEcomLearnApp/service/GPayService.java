package com.lukasz2.SpringBootEcomLearnApp.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class GPayService implements PaymentService, InitializingBean, DisposableBean {
    @Override
    public void processPayment(double amount) {
        System.out.println("GPay Payment processing");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertiesSet");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");

    }
}
