package com.example.ecommerce;

import com.example.ecommerce.domain.dto.*;
import com.example.ecommerce.domain.entities.*;
import com.example.ecommerce.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @InjectMocks
    private BrandService brandService;

    @InjectMocks
    private CategoryService categoryService;

    @InjectMocks
    public DiscountService discountService;

    @InjectMocks
    private StockService stockService;

    @InjectMocks
    private SubCategoryService subCategoryService;

    @InjectMocks
    private SupplierService supplierService;

    private static final Supplier supplier = new Supplier("Transistors Unlimited", "Transistors Unlimited LTDA", "We made transistors", "11110001/1",null, null,null);

    private static final Brand brand = new Brand("Guugle","A new way to search your thoughts",null,null);

    private static final Category category = new Category("Eletricidade",null);

    private static final Discount discount = new Discount(15.0,1,0.15,null);

    private static final List<Stock> stockList = new ArrayList<>();

    private static final List<SubCategory> subCategoryList = new ArrayList<>();

    private static final List<Review> reviewList = new ArrayList<>();

    @Test
    public void testProductCreate(){

        this.stockList.add(new Stock( 1, null, null));
        this.subCategoryList.add(new SubCategory( "SubCategory", null));
        this.reviewList.add(new Review( 5, "A good job", new Date(), null, null));

        //BrandDTO createBrandDTO = new BrandDTO(null, "Guugle", "A new way to search your thoughts", null, null);
        //this.brandService.create(createBrandDTO);

        CategoryDTO createCategoryDTO = new CategoryDTO(null, "Eletricidade", null);
        this.categoryService.create(createCategoryDTO);

        DiscountDTO createDiscountDTO = new DiscountDTO(null, 15.0, 1, 0.15, null);
        this.discountService.create(createDiscountDTO);

        StockDTO createStockDTO = new StockDTO(null, 1, null, null);
        this.stockService.create(createStockDTO);

        SubCategoryDTO createSubCategoryDTO = new SubCategoryDTO(null, "SubCategory", null);
        this.subCategoryService.create(createSubCategoryDTO);

        SupplierDTO createSupplierDTO = new SupplierDTO(null,"Transistors Unlimited", "Transistors Unlimited LTDA", "We made transistors", "11110001/1",null, null,null);
        this.supplierService.create(createSupplierDTO);

        ProductDTO newProduct = new ProductDTO(null, "Product", "1", null, null, this.stockList , this.discount, this.category, this.subCategoryList, this.brand, this.reviewList, this.supplier);

        ProductDTO createdProduct = this.productService.create(newProduct);

        assertEquals(newProduct.display_name(), createdProduct.display_name());
        assertEquals(newProduct.description(), createdProduct.description());
        assertEquals(newProduct.price(), createdProduct.price());
        assertEquals(newProduct.applicable_discount(), createdProduct.applicable_discount());
        assertEquals(newProduct.discount(), createdProduct.discount());
        assertEquals(newProduct.supplier(), createdProduct.supplier());
        assertEquals(newProduct.category(), createdProduct.category());
        assertEquals(newProduct.subCategoryList(), createdProduct.subCategoryList());
        assertEquals(newProduct.stockList(), createdProduct.stockList());
        assertEquals(newProduct.reviewList(), createdProduct.reviewList());

    }

    @Test
    public void testProductUpdate(){
        ProductDTO newProduct = new ProductDTO(null, "Product", "1", null, null, null, null, null, null, null, null, null);

        ProductDTO createdProduct = this.productService.create(newProduct);

        ProductDTO updateProductDTO = new ProductDTO(createdProduct.id(), "Product", "2", null, null, null, null, null, null, null, null, null);

        ProductDTO updatedProduct = this.productService.update(createdProduct.id(), updateProductDTO);

        assertEquals(updateProductDTO.display_name(), updatedProduct.display_name());
        assertEquals(updateProductDTO.description(), updatedProduct.description());
        assertEquals(updateProductDTO.price(), updatedProduct.price());
        assertEquals(updateProductDTO.applicable_discount(), updatedProduct.applicable_discount());
        assertEquals(updateProductDTO.discount(), updatedProduct.discount());
        assertEquals(updateProductDTO.supplier(), updatedProduct.supplier());
        assertEquals(updateProductDTO.category(), updatedProduct.category());
        assertEquals(updateProductDTO.subCategoryList(), updatedProduct.subCategoryList());
        assertEquals(updateProductDTO.stockList(), updatedProduct.stockList());
        assertEquals(updateProductDTO.reviewList(), updatedProduct.reviewList());
    }
}
