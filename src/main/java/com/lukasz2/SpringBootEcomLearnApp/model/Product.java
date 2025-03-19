package com.lukasz2.SpringBootEcomLearnApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Entity
@Component
public class Product {
    @Id
    private int prodId;
    private String prodName;
    private int price;

    public Product() {
    }
}
