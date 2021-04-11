package com.mediatheque.mediatheque.controller;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/photo")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getPhoto(){
        return photoService.getPhoto();
    }

    @PostMapping(value = "/create")
    public void registerNewPhoto(@RequestBody Photo photo){
        photoService.addNewPhoto(photo);
    }
}

