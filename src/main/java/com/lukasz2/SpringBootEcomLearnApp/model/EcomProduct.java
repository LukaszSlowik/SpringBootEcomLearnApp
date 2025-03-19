package com.lukasz2.SpringBootEcomLearnApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EcomProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Product name cannot be null")
    private String name;
    @NotNull(message = "Price cannot be null")
    @Min(value=0, message ="Value must be greater than 0")
    @Max(value = 100, message = "Value should be less than 100")
    private Integer price;
    @Size(max=5,message = "Description cannot exceed 5 characters")
    private String description;
    private Integer stock;

}
