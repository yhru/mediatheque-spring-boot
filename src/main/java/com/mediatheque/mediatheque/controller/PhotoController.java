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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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

    @GetMapping("/{id}")
    public Photo getPhotoById(@PathVariable Long id) {
        return photoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Photo not found with id : " + id));
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
    public ResponseEntity<?> showPhoto(@PathVariable Long id) {
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
            Files.deleteIfExists(imgPath);
        } catch (IOException | ModelException | TranslateException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/datas/{id}")
    public ResponseEntity<?> fetchDatasInPicture(@PathVariable Long id) {
        Map<String, Double> dataInPicture = getPhotoById(id).getDataInPicture();
        return ResponseEntity
                .ok()
                .body(dataInPicture);
    }

    @GetMapping("/agreement/{id}")
    public ResponseEntity<?> fetchAgreementDate(@PathVariable Long id) {
        Date agreementDate = getPhotoById(id).getAgreementDate();
        return ResponseEntity
                .ok()
                .body(agreementDate);
    }

    @GetMapping("/resolution/{id}")
    public ResponseEntity<?> fetchResolution(@PathVariable Long id) {
        long resolution = getPhotoById(id).getResolution();
        return ResponseEntity
                .ok()
                .body(resolution);
    }

    @GetMapping("/name/{id}")
    public ResponseEntity<?> fetchName(@PathVariable Long id) {
        String name = getPhotoById(id).getName();
        return ResponseEntity
                .ok()
                .body(name);
    }

    @PutMapping(value = "/set/agreement/{id}")
    public void setAgreementDate(
            @PathVariable Long id,
            @RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date
    ) {
        Photo photo = getPhotoById(id);
        photo.setAgreementDate(date);
        photoRepository.save(photo);
    }
}

