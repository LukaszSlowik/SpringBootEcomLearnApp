package com.lukasz2.SpringBootEcomLearnApp.service;

import com.lukasz2.SpringBootEcomLearnApp.model.EcomProduct;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomProductRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.isNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EcomProductServiceTest {

    @Mock
    EcomProductRepo productRepo;

    @InjectMocks
    EcomProductService productService;

    EcomProduct product;

    @BeforeEach
    public void init() {
        product = new EcomProduct();
        product.setName("f");
        product.setDescription("sdds");
        product.setId(1);
        product.setPrice(4);
    }

    @Test
    public void addProductShouldAddProductSuccessfully() {

        Mockito.when(productRepo.save(product)).thenReturn(product);
        EcomProduct addedProduct = productService.addProduct(product);
        verify(productRepo, times(1)).save(product);
        assertEquals(addedProduct, product);
    }

    @Test
    public void addProductShouldThrowExceptionForInvalidProductionName() {

        product.setName("");
        assertThrows(RuntimeException.class, () -> {
            productService.addProduct(product);
        });
        verify(productRepo, never()).save(product);
    }

    @Test
    public void deleteProductShouldDeleteProductSuccessfully(){


       productService.deleteProduct(product.getId());
        verify(productRepo,times(1)).deleteById(product.getId());
    }

    @Test
    public void deleteProductShouldThrowExceptionForIdNull(){
        product.setId(null);
        doThrow(IllegalArgumentException.class).when(productRepo).deleteById(product.getId());
        assertThrows(IllegalArgumentException.class,()->{
           productService.deleteProduct( product.getId());
        });
    }

    @AfterAll
    public static void Destroy() {
        System.out.println("AfterAll");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("AfterEach");
    }
}
