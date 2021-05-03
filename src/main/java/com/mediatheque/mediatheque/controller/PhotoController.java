package com.mediatheque.mediatheque.controller;

import ai.djl.ModelException;
import ai.djl.translate.TranslateException;
import com.mediatheque.mediatheque.DJL.ObjectDetection;
import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import com.mediatheque.mediatheque.services.AddTextWatermark;
import com.mediatheque.mediatheque.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/photo")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getPhoto() {
        return photoRepository.findAll();
    }

    @GetMapping("/file/{id}/download")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Long id) {
        Optional<Photo> fileOptional = photoRepository.findById(id);
        if (fileOptional.isPresent()) {
            Photo file = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .body(file.getImage());
        }
        return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<?> showPhoto(@PathVariable Long id) throws IOException {
        Optional<Photo> fileOptional = photoRepository.findById(id);
        if (fileOptional.isPresent()) {
            Photo file = fileOptional.get();
            ByteArrayResource ressource = new ByteArrayResource(file.getImage());
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(ressource);
        }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping(value = "/upload")
    public void uploadPhoto(@RequestParam("image") MultipartFile image) {
        try {
            byte[] imgBytes = image.getBytes();
            Path imgPath = Paths.get(image.getOriginalFilename());
            Files.write(imgPath, imgBytes);
            byte[] imageCopyrighted = AddTextWatermark.addWatermark(image.getInputStream(), imgPath.toString());
            Photo photo = new Photo(image.getOriginalFilename(), image.getSize(), ObjectDetection.getDetectedObject(imgPath), imageCopyrighted);
            photoRepository.save(photo);
        } catch (IOException | ModelException | TranslateException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/datas/{id}")
    public ResponseEntity<?> fetchDatasInPicture(@PathVariable Long id) throws IOException {
        Map<Integer, String> dataInPicture = photoRepository.findById(id).get().getDataInPicture();
        return ResponseEntity
                .ok()
                .body(dataInPicture);
    }
}

