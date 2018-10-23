package com.kharidlo.service.product.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface IFileStorageService {
    String uploadImage(MultipartFile file) throws FileNotFoundException;
}
