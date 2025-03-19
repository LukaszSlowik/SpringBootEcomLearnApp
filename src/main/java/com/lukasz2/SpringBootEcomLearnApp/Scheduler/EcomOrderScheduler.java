package com.lukasz2.SpringBootEcomLearnApp.Scheduler;

import com.lukasz2.SpringBootEcomLearnApp.model.Order;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomOrderRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EcomOrderScheduler {
    private final EcomOrderRepo ecomOrderRepo;

    public EcomOrderScheduler(EcomOrderRepo ecomOrderRepo) {
        this.ecomOrderRepo = ecomOrderRepo;
    }
//@Scheduled(initialDelay = 10000, fixedDelay = 10000)
    public void processPendingOrders(){
        System.out.println("Processing Orders");
        List<Order> orders = ecomOrderRepo.findByStatus("PENDING");
        orders.forEach(order -> {
            order.setStatus("COMPLETED");
            ecomOrderRepo.save(order);
        });
        System.out.println("Processed  pending orders. " + orders.size());


    }
}
