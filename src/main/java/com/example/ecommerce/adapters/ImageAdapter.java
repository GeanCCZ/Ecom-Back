package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.ImageDTO;
import com.example.ecommerce.domain.entities.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageAdapter implements Adapter<Image, ImageDTO> {

    @Override
    public Image fromDto(ImageDTO dto) {
        return new Image(
                dto.public_id(),
                dto.source(),
                dto.alt(),
                dto.url(),
                dto.sequence(),
                dto.image_file(),
                dto.brand(),
                dto.product(),
                dto.rootGroup()
        );
    }

    @Override
    public ImageDTO fromEntity(Image entity) {
        return new ImageDTO(
                entity.getId(),
                entity.getPublic_id(),
                entity.getSource(),
                entity.getAlt(),
                entity.getUrl(),
                entity.getSequence(),
                entity.getImage_file(),
                entity.getBrand(),
                entity.getProduct(),
                entity.getRootGroup()
        );
    }
}
