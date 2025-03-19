package com.lukasz2.SpringBootEcomLearnApp.controller;

import com.lukasz2.SpringBootEcomLearnApp.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api")
public class AsyncTest {
    private final ProductService productService;

    public AsyncTest(@Qualifier("ecomProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/asyncTest")
    public ResponseEntity<String> testAsync() throws ExecutionException, InterruptedException {
      //Future<String> result =  productService.testAsync();
        CompletableFuture<String> result = productService.testAsync();

     return   ResponseEntity.ok(result.get());

    }
    @GetMapping("/asyncVoidError")
    public ResponseEntity<String> testAsyncError(){
        productService.testAsyncError();

        return ResponseEntity.ok().build();
    }


}
