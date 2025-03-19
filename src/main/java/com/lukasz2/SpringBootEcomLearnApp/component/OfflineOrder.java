package com.lukasz2.SpringBootEcomLearnApp.component;

import org.springframework.stereotype.Component;

@Component
public class OfflineOrder implements Order{
    public OfflineOrder(){
        System.out.println("Init OnlineOrder");
    }
}
