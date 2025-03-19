package com.lukasz2.SpringBootEcomLearnApp.repository;

import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EcomProductRepo extends JpaRepository<EcomProduct,Integer> {
    Optional<EcomProduct> findByName(String name);

}
