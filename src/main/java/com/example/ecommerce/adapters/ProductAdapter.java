package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter implements Adapter<Product, ProductDTO> {

    @Override
    public Product fromDto(ProductDTO dto) {
        return new Product(
                dto.display_name(),
                dto.description(),
                dto.price(),
                dto.applicable_discount(),
                dto.stockList(),
                dto.discount(),
                dto.image(),
                dto.category(),
                dto.sub_category(),
                dto.brand(),
                dto.reviewList(),
                dto.supplier()
        );
    }

    @Override
    public ProductDTO fromEntity(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getApplicableDiscount(),
                entity.getStockList(),
                entity.getDiscount(),
                entity.getImageList(),
                entity.getCategory(),
                entity.getSubCategory(),
                entity.getBrand(),
                entity.getReviewList(),
                entity.getSupplier()
        );
    }
}
