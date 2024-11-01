package com.giodefa.petshops.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.giodefa.petshops.dto.ImageDto;
import com.giodefa.petshops.model.Image;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto>  saveImage(List<MultipartFile> file, Long productId);
    void updateImage(MultipartFile file, long imageId);
}
