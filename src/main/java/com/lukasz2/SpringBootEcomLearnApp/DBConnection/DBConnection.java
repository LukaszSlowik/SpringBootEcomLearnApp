package com.lukasz2.SpringBootEcomLearnApp.DBConnection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {
//    @Autowired (required = false)
//    MySqlConnection mySqlConnection;
//    @Autowired (required = false)
//    NoSQLConnection noSQLConnection;
    @Value("${DBusername}")
    String username;
    @Value("${password}")
    String password;
    @PostConstruct
    public void init(){
        System.out.println("BDconnection init");
        System.out.println("username: " + username + " | password: " + password);
       // System.out.println("MySqlConnection " + mySqlConnection);
       // System.out.println("BDconnection init " + noSQLConnection);
    }
}
