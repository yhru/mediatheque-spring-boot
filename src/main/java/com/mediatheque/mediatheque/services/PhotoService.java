package com.mediatheque.mediatheque.services;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @GetMapping
    public List<Photo> getPhoto(){
        return photoRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Photo addNewPhoto(Photo photo) {
        System.out.println(photo);
        return photoRepository.saveAndFlush(photo);
    }
}
