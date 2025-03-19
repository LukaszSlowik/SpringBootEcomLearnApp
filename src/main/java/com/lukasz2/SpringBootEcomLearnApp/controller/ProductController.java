package com.lukasz2.SpringBootEcomLearnApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<String> getBookById
            (@PathVariable("productId") Integer bookId){
        return ResponseEntity.ok("product");


//    @Autowired
//    ProductService service;
//    @RequestMapping("/products")
//    public List<Product> getProducts(){
//        return service.getProducts();
//
//    }
//
//    @RequestMapping("/products/{prodId}")
//    public Product getProductById(@PathVariable int prodId){
//        return service.getProductById(prodId);
//    }
//
//  @PostMapping("/products")
//    public void addProduct(@RequestBody  Product product){
//      System.out.println(product);
//        service.addProduct(product);
//  }
//  @DeleteMapping("/products/{prodId}")
//    public void deleteProduct(@PathVariable int prodId){
//        service.deleteProduct(prodId);
//  }
//@PutMapping("/products")
//  public void  updateProduct(@RequestBody Product prod){
//        service.updateProduct(prod);
  }




}
