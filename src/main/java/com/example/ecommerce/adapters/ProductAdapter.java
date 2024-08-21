package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter implements Adapter<Product, ProductDTO> {

    @Override
    public Product fromDto(ProductDTO dto) {
        return new Product(
                dto.displayName(),
                dto.description(),
                dto.price(),
                dto.discountEnabled(),
                dto.stockList(),
                dto.discount(),
                null,
                dto.category(),
                dto.subCategoryList(),
                dto.brand(),
                dto.reviewList(),
                dto.supplier()
        );
    }

    @Override
    public SupplierDTO fromEntity(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getDiscountEnabled(),
                entity.getStockList(),
                entity.getDiscount(),
                entity.getCategory(),
                entity.getSubCategory(),
                entity.getBrand(),
                entity.getReviewList(),
                entity.getSupplier()
        );
    }
}
