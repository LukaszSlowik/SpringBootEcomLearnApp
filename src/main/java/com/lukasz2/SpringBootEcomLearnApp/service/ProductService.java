package com.lukasz2.SpringBootEcomLearnApp.service;


import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public interface ProductService {


    Optional<EcomProduct> findById(Integer productId);

    Optional<EcomProduct> findByName(String name);

    EcomProduct addProduct(EcomProduct product);

    List<EcomProduct> getAllProducts();

    CompletableFuture<String> testAsync();
    void deleteProduct(Integer id);


    void testAsyncError();
}
