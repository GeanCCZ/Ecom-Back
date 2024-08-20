package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.Stock;
import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends CRUDService<Product, UUID, ProductDTO>{

    private final ProductRepository productRepository;
    private final Adapter<Product,ProductDTO> adapter;
    private final BrandService brandService;
    private final CategoryService categoryService;
    public final DiscountService discountService;
    private final StockService stockService;
    private final SubCategoryService subCategoryService;
    private final SupplierService supplierService;

    public ProductService (CRUDRepository<Product,UUID> repository, Adapter<Product,ProductDTO> adapter,ProductRepository productRepository, StockService stockService,SupplierService supplierService, BrandService brandService,CategoryService categoryService,SubCategoryService subCategoryService, DiscountService discountService){
        super(repository,adapter);
        this.productRepository = productRepository;
        this.adapter = adapter;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.discountService = discountService;
        this.stockService = stockService;
        this.subCategoryService = subCategoryService;
        this.supplierService = supplierService;
    }

    public ProductDTO create(ProductDTO dto){

        if(!dto.stockList().isEmpty()){
            List<Stock> stockList = new ArrayList<>();
            for(Stock stock : dto.stockList()){
                stockList.add(
                        this.stockService.getEntityFromDTO(
                                this.stockService.create(
                                        this.stockService.getDTOFromEntity(
                                                stock
                                        )
                                )
                        )
                );
            }
            dto.stockList().clear();
            dto.stockList().addAll(stockList);
        } else {
            throw new RuntimeException("Stock list is empty");
        }

        if (this.brandService.findByDisplayName(dto.brand().getDisplayName()).isEmpty()){
            throw new RuntimeException("Invalid brand");
        }

        if (this.categoryService.findByDisplayName(dto.category().getDisplayName()).isEmpty()) {
            throw new RuntimeException("Invalid category");
        }

        if (!dto.subCategoryList().isEmpty()){
            List<SubCategory> subCategoryList = new ArrayList<>();

            for(SubCategory subCategory : dto.subCategoryList()){

                if(this.subCategoryService.findByDisplayName(subCategory.getDisplayName()).isPresent()) {

                    subCategoryList.add(subCategory);

                }

            }

            dto.subCategoryList().clear();
            dto.subCategoryList().addAll(subCategoryList);
        }
        if (this.supplierService.findByLegalName(dto.supplier().getLegalName()).isEmpty()){
            throw new RuntimeException("Invalid supplier");
        }

        Product newProduct = this.getEntityFromDTO(dto);

        return this.getDTOFromEntity(this.productRepository.save(newProduct));
    }

    @Override
    protected void checkSave(ProductDTO dto, Product entity) {
        boolean alreadyExists = this.productRepository.findByDisplayName(dto.displayName()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

    protected Product getEntityFromDTO(ProductDTO dto){
        return this.adapter.fromDto(dto);
    }

    protected ProductDTO getDTOFromEntity(Product entity){
        return this.adapter.fromEntity(entity);
    }
}
