package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.*;
import com.example.ecommerce.domain.entities.*;
import com.example.ecommerce.repository.custom.ProductRepository;
import com.example.ecommerce.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private CRUDService<Product, UUID, ProductDTO> service;

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

        Supplier productSupplier = new Supplier(supplierDTO.tradeName(),supplierDTO.legalName(),supplierDTO.description(),supplierDTO.cnpj(),supplierDTO.addressList(),supplierDTO.stockList(),supplierDTO.productList());

        when(supplierService.create(supplierDTO)).thenReturn(supplierDTO);

        supplierService.create(supplierDTO);

        when(supplierService.findByLegalName(supplierDTO.legalName())).thenReturn(Optional.ofNullable(productSupplier));

        Stock productStock = new Stock(100, productSupplier, null);
        List<Stock> stockList = new ArrayList<>() {{
            add(productStock);
        }};

        DiscountDTO discountDTO = new DiscountDTO(UUID.randomUUID(), 10.0, 1, 0.10, null);

        Discount productDiscount = discountAdapter.fromDto(discountDTO);

        when(discountService.create(discountDTO)).thenReturn(discountDTO);

        CategoryDTO categoryDTO = new CategoryDTO(UUID.randomUUID(), "CategoryName", null);

        Category productCategory = new Category(categoryDTO.displayName(), categoryDTO.productList());

        when(categoryService.create(categoryDTO)).thenReturn(categoryDTO);

        when(categoryService.findByDisplayName(categoryDTO.displayName())).thenReturn(Optional.ofNullable(productCategory));

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO(UUID.randomUUID(), "SubCategoryName", null);

        SubCategory productSubCategory = new SubCategory(subCategoryDTO.displayName(), subCategoryDTO.productList());

        when(subCategoryService.create(subCategoryDTO)).thenReturn(subCategoryDTO);

        when(subCategoryService.findByDisplayName(subCategoryDTO.displayName())).thenReturn(Optional.ofNullable(productSubCategory));

        List<SubCategory> subCategoryList = new ArrayList<>() {{
            add(productSubCategory);
        }};

        BrandDTO brandDTO = new BrandDTO(UUID.randomUUID(), "BrandName", "", null, null);
        Brand productBrand = new Brand(brandDTO.displayName(),brandDTO.description(),brandDTO.image(),brandDTO.productList());

        when(brandService.findByDisplayName(brandDTO.displayName())).thenReturn(Optional.empty());

        when(brandService.create(brandDTO)).thenReturn(brandDTO);

        brandService.create(brandDTO);

        when(brandService.findByDisplayName(brandDTO.displayName())).thenReturn(Optional.ofNullable(productBrand));
        ProductDTO productDTO = new ProductDTO(UUID.randomUUID(), "ProductName", "Description", 110.11, true, stockList, productDiscount, productCategory, subCategoryList, productBrand, new ArrayList<>(), productSupplier);

        Product product = new Product(productDTO.displayName(),productDTO.description(),productDTO.price(),productDTO.discountEnabled(),productDTO.stockList(),productDTO.discount(),null,productDTO.category(),productDTO.subCategoryList(),productDTO.brand(),productDTO.reviewList(),productDTO.supplier());

        when(productService.create(productDTO)).thenReturn(productDTO);

        productService.create(productDTO);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

    }

    @Test
    void updateProductSuccessfully(){
        UUID id = UUID.randomUUID();
        ProductDTO productDTO = new ProductDTO(id, "ProductName", "Description", 110.11, true, null, null, null, null, null, null, null);
        Product product = new Product(productDTO.displayName(),productDTO.description(),productDTO.price(),productDTO.discountEnabled(),productDTO.stockList(),productDTO.discount(),null,productDTO.category(),productDTO.subCategoryList(),productDTO.brand(),productDTO.reviewList(),productDTO.supplier());

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        when(service.findById(id)).thenReturn(product);

        productService.update(id, productDTO);

        verify(productRepository).save(product);

    }

    @Test
    void deleteBrandSuccessfully() {
        UUID id = UUID.randomUUID();
        ProductDTO productDTO = new ProductDTO(id, "ProductName", "Description", 110.11, true, null, null, null, null, null, null, null);
        Product product = new Product(productDTO.displayName(), productDTO.description(), productDTO.price(), productDTO.discountEnabled(), productDTO.stockList(), productDTO.discount(), null, productDTO.category(), productDTO.subCategoryList(), productDTO.brand(), productDTO.reviewList(), productDTO.supplier());

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        productService.delete(id);

        verify(productRepository).deleteById(productDTO.id());
    }

    @Test
    void findProductByIdSuccessfully() {
        UUID id = UUID.randomUUID();
        ProductDTO productDTO = new ProductDTO(id, "ProductName", "Description", 110.11, true, null, null, null, null, null, null, null);
        Product product = new Product(productDTO.displayName(), productDTO.description(), productDTO.price(), productDTO.discountEnabled(), productDTO.stockList(), productDTO.discount(), null, productDTO.category(), productDTO.subCategoryList(), productDTO.brand(), productDTO.reviewList(), productDTO.supplier());

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        productService.findById(id);

        verify(productRepository, Mockito.times(2)).findById(id);
    }

}
