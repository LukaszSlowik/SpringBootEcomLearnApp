package com.lukasz2.SpringBootEcomLearnApp.service;

import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EcomProductService  implements ProductService{
    private final EcomProductRepo ecomProductRepo;
    //private static final  Logger logger = LoggerFactory.getLogger(ProductService.class);

    public EcomProductService(EcomProductRepo ecomProductRepo){//Logger logger) {
        this.ecomProductRepo = ecomProductRepo;
        //this.logger = logger;
        System.out.println("ProductService created");
    }

    public EcomProduct addProduct(EcomProduct product){
        log.info("adding product in DB");
        boolean validation = validateProductName(product.getName());
        log.warn("warning test");
        log.trace("Trace info");
        log.error("Error info");
        if(validation) {
            return ecomProductRepo.save(product);
        } else {
            throw  new RuntimeException("Invalid Name of Product");
        }
    }

    @Override
    public List<EcomProduct> getAllProducts() {
        return ecomProductRepo.findAll();
    }

    @Override
    @Async
    public CompletableFuture<String> testAsync() {
        log.info("Inside asyncTest: {}", Thread.currentThread().getName());
        try {
            Thread.sleep(50000);
        } catch(Exception e){

        }

        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        ecomProductRepo.deleteById(id);
    }

    @Override
    @Async
    public void testAsyncError() {
        int i = 0;
        System.out.println(5/i);

    }

    @Override
    public Optional<EcomProduct> findById(Integer id){
        return ecomProductRepo.findById(id);
    }

    @Override
    public Optional<EcomProduct> findByName(String name) {
        return ecomProductRepo.findByName(name);
    }

    private boolean validateProductName(String name){
        return name !=null && !name.isEmpty();
    }


}
