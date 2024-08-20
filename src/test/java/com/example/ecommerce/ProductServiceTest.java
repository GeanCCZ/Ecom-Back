package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.*;
import com.example.ecommerce.domain.entities.*;
import com.example.ecommerce.repository.custom.ProductRepository;
import com.example.ecommerce.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Adapter<Product, ProductDTO> adapter;

    @Mock
    private BrandService brandService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private DiscountService discountService;

    @Mock
    private StockService stockService;

    @Mock
    private SubCategoryService subCategoryService;

    @Mock
    private SupplierService supplierService;

    @Test
    void createProductSuccessfully() {

        new Supplier("SupplierName", "Supplier", "Sup Description", "", null, null,null);



        List<Stock> stockList = new ArrayList<>();

        when(stockService.create(any(StockDTO.class))).thenReturn();
        when(stockService.getDTOFromEntity(any(Stock.class))).thenReturn(new StockDTO(UUID.randomUUID(), 10, UUID.randomUUID(), UUID.randomUUID()));
        when(stockService.getEntityFromDTO(any(StockDTO.class))).thenReturn(new Stock(UUID.randomUUID(), 10, new Supplier(UUID.randomUUID()), new Product(UUID.randomUUID()));

        //ProductDTO productDTO = new ProductDTO(UUID.randomUUID(), "ProductName", "Description", 110.11, true,);
    }

}
