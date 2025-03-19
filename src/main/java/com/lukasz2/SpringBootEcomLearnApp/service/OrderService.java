package com.lukasz2.SpringBootEcomLearnApp.service;


import com.lukasz2.SpringBootEcomLearnApp.Dto.OrderRequest;
import com.lukasz2.SpringBootEcomLearnApp.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order createOrder(OrderRequest request);
}
