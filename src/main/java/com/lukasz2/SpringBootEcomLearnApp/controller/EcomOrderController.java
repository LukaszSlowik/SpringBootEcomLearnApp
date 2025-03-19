package com.lukasz2.SpringBootEcomLearnApp.controller;

import com.lukasz2.SpringBootEcomLearnApp.Dto.OrderRequest;
import com.lukasz2.SpringBootEcomLearnApp.exceptions.ProductNotFoundException;
import com.lukasz2.SpringBootEcomLearnApp.model.Order;
import com.lukasz2.SpringBootEcomLearnApp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class EcomOrderController {

    private final OrderService orderService;
    public EcomOrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request){
        Order order = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer orderId){
       throw new ProductNotFoundException("Exception order");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }
}
