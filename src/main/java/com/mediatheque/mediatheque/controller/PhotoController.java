package com.mediatheque.mediatheque.controller;

import ai.djl.ModelException;
import ai.djl.translate.TranslateException;
import com.fasterxml.jackson.annotation.JsonView;
import com.mediatheque.mediatheque.DJL.ObjectDetection;
import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import com.mediatheque.mediatheque.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    public List<Photo> getPhoto(){
        return photoRepository.findAll();
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<Photo> fileOptional = photoRepository.findById(id);

        if(fileOptional.isPresent()) {
            Photo file = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .body(file.getImage());
        }

        return ResponseEntity.status(404).body(null);
    }

    @PostMapping(value = "/upload")
    public void registerNewPhoto(
            @RequestParam("image") MultipartFile image
//            @RequestParam("data_in_picture") String dataInPicture
            ) {
        try {
            byte[] imgBytes = image.getBytes();
            Path imgPath = Paths.get(image.getOriginalFilename());
            Files.write(imgPath, imgBytes);
            Photo photo = new Photo(image.getOriginalFilename(), image.getSize(), ObjectDetection.getDetectedObject(imgPath), imgBytes);
            photoRepository.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ModelException e) {
            e.printStackTrace();
        } catch (TranslateException e) {
            e.printStackTrace();
        }
    }

}

