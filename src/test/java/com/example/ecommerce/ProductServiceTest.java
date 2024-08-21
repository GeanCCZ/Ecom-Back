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
    private Adapter<Product, ProductDTO> productAdapter;
    @Mock
    private ProductRepository productRepository;

    @Mock
    private Adapter<Brand, BrandDTO> brandAdapter;
    @Mock
    private BrandService brandService;

    @Mock
    private Adapter<Category, CategoryDTO> categoryAdapter;
    @Mock
    private CategoryService categoryService;

    @Mock
    private Adapter<Discount, DiscountDTO> discountAdapter;
    @Mock
    private DiscountService discountService;

    @Mock
    private Adapter<Stock, StockDTO> stockAdapter;
    @Mock
    private StockService stockService;

    @Mock
    private Adapter<SubCategory, SubCategoryDTO> subCategoryAdapter;
    @Mock
    private SubCategoryService subCategoryService;

    @Mock
    private Adapter<Supplier, SupplierDTO> supplierAdapter;
    @Mock
    private SupplierService supplierService;

    @Test
    void createProductSuccessfully() {
        SupplierDTO supplierDTO = new SupplierDTO(UUID.randomUUID(), "SupplierName", "Supplier", "Sup Description", "", null, null, null);

        Supplier productSupplier = supplierAdapter.fromDto(supplierDTO);

        when(supplierService.create(supplierDTO)).thenReturn(supplierDTO);

        Stock productStock = new Stock(100, productSupplier, null);
        List<Stock> stockList = new ArrayList<>() {{
            add(productStock);
        }};

//        when(stockService.create(any(StockDTO.class))).thenReturn();
//        when(stockService.getDTOFromEntity(any(Stock.class))).thenReturn(new StockDTO(UUID.randomUUID(), 10, UUID.randomUUID(), UUID.randomUUID()));
//        when(stockService.getEntityFromDTO(any(StockDTO.class))).thenReturn(new Stock(UUID.randomUUID(), 10, new Supplier(UUID.randomUUID()), new Product(UUID.randomUUID()));

        //ProductDTO productDTO = new ProductDTO(UUID.randomUUID(), "ProductName", "Description", 110.11, true,);
    }

}
