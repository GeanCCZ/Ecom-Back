package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.ImageDTO;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageService extends CRUDService<Image, UUID, ImageDTO>{

    private final ImageRepository imageRepository;

    public ImageService(CRUDRepository<Image,UUID> repository, Adapter<Image, ImageDTO> adapter, ImageRepository imageRepository){
        super(repository,adapter);
        this.imageRepository = imageRepository;
    }

    @Override
    protected void checkSave(ImageDTO dto, Image entity){
        boolean alreadyExists = this.imageRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
