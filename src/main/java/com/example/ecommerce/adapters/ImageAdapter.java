package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.ImageDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageAdapter implements Adapter<Image, ImageDTO> {

    @Override
    public Image fromDto(ImageDTO dto) {
        return new Image(
                dto.publicId(),
                dto.source(),
                dto.alt(),
                dto.url(),
                dto.sequence(),
                dto.imageFile(),
                dto.brand(),
                dto.product(),
                dto.rootGroup()
        );
    }

    @Override
    public SupplierDTO fromEntity(Image entity) {
        return new ImageDTO(
                entity.getId(),
                entity.getPublicId(),
                entity.getSource(),
                entity.getAlt(),
                entity.getUrl(),
                entity.getSequence(),
                entity.getImageFile(),
                entity.getBrand(),
                entity.getProduct(),
                entity.getRootGroup()
        );
    }
}
