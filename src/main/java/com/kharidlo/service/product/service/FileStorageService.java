package com.kharidlo.service.product.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService implements IFileStorageService {

    @Override
    public String uploadImage(MultipartFile file) {

        String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/productImages/").path("Img" + System.currentTimeMillis() + ".jpg").toUriString();

        Path path = Paths.get(filePath);

        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }

        catch (Exception ex){}

        return filePath;
    }
}
