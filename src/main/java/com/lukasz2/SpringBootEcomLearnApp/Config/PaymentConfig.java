package com.lukasz2.SpringBootEcomLearnApp.Config;

import com.lukasz2.SpringBootEcomLearnApp.service.CreditCardService;
import com.lukasz2.SpringBootEcomLearnApp.service.GPayService;
import com.lukasz2.SpringBootEcomLearnApp.service.PaymentService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
   // @Bean if commented than Service need to have a @Component/ @Service annotation
    public PaymentService creditCardPaymentService(){
        return new CreditCardService();
    }
   // @Bean
    public PaymentService gpayPaymentService(){
        return new GPayService();
    }
}
