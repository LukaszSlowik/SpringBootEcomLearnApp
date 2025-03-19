package com.lukasz2.SpringBootEcomLearnApp.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

    final Order order;
    //final OnlineOrder onlineOrder;


    public User(@Qualifier("onlineOrder") Order order){
        this.order = order;

        System.out.println("Initializing User");
    }


}
