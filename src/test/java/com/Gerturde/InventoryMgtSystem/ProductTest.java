package com.Gerturde.InventoryMgtSystem;

import com.Gerturde.InventoryMgtSystem.models.Product;
import com.Gerturde.InventoryMgtSystem.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTest {

    @Autowired
    private ProductService productService;
    @Test
    public void testFindAll(){
        List<Product> productList = productService.getAllProducts();
        assertEquals(1,productList.size());
    }

    @Test
    public void testSave(){
        Product pro = new Product();
        pro.setCode("INSYu");
        pro.setName("COCO");
        pro.setDescription("utility");

        Product product = productService.saveProduct(pro);
        assertNotNull(product);
    }
}
