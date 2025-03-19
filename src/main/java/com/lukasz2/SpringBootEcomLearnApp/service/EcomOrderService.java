package com.lukasz2.SpringBootEcomLearnApp.service;

import com.lukasz2.SpringBootEcomLearnApp.Dto.OrderRequest;
import com.lukasz2.SpringBootEcomLearnApp.model.Order;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomOrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcomOrderService implements OrderService{

    private final EcomOrderRepo ecomOrderRepo;

    public EcomOrderService(EcomOrderRepo ecomOrderRepo) {
        this.ecomOrderRepo = ecomOrderRepo;
    }
    @Override
    public List<Order> getAll(){
        return ecomOrderRepo.findAll();
    }

    @Override
    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerEmail(request.getCustomerEmail());
        return ecomOrderRepo.save(order);
    }
}
