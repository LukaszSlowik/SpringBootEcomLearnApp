package com.lukasz2.SpringBootEcomLearnApp.repository;

import com.lukasz2.SpringBootEcomLearnApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
//Optional<Product> findByName(String name);


}
