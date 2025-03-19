package com.lukasz2.SpringBootEcomLearnApp.service;

import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TestProductService implements ProductService{
    @Override
    public Optional<EcomProduct> findById(Integer productId) {
        return Optional.empty();
    }

    @Override
    public Optional<EcomProduct> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public EcomProduct addProduct(EcomProduct product) {
        return null;
    }

    @Override
    public List<EcomProduct> getAllProducts() {
        return List.of();
    }

    @Override
    public CompletableFuture<String> testAsync() {

        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public void testAsyncError() {

    }
}
