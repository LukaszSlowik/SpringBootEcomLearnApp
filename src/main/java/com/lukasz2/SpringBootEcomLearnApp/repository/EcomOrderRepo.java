package com.lukasz2.SpringBootEcomLearnApp.repository;

import com.lukasz2.SpringBootEcomLearnApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcomOrderRepo extends JpaRepository<Order,Long> {
    List<Order> findByStatus(String status);
}
