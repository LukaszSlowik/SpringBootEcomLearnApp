package com.lukasz2.SpringBootEcomLearnApp.controller;

import com.lukasz2.SpringBootEcomLearnApp.exceptions.ProductNotFoundException;
import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;
import com.lukasz2.SpringBootEcomLearnApp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product/v1")
public class EcomProductController {

    private final ProductService productService;


    public EcomProductController(@Qualifier("ecomProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getBookId (@PathVariable("productId") Integer productId){
        EcomProduct product =  productService.findById(productId).
                orElseThrow(()-> new ProductNotFoundException("Product not found with id: " + productId));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/getProduct/{name}")
    public ResponseEntity<EcomProduct> getProductByName(@PathVariable String name){
        EcomProduct product = productService.findByName(name)
                .orElseThrow(()-> new ProductNotFoundException("Product not found with name: " + name));
           return  ResponseEntity.ok(product);

}

@PostMapping("/addProduct")
    public ResponseEntity<EcomProduct> addProduct(@Valid @RequestBody EcomProduct product){
        EcomProduct createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
}




}
