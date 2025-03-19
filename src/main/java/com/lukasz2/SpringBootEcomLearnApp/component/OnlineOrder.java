package com.lukasz2.SpringBootEcomLearnApp.component;

import org.springframework.stereotype.Component;

@Component

public class OnlineOrder implements Order {
    public OnlineOrder(){
        System.out.println("Init Online Order");
    }
}
