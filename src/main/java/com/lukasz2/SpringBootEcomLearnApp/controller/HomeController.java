package com.lukasz2.SpringBootEcomLearnApp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@RequestMapping("/")
    public String greet(){
    System.out.println("I'm here");
        return "Welcome!";
    }
    @RequestMapping("/about")
    public String about(){
    return "about";
    }
}
