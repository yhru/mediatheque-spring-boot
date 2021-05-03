package com.mediatheque.mediatheque.services;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getPhoto(){
        return photoRepository.findAll();
    }

    public Photo addNewPhoto(Photo photo) {
        System.out.println(photo);
        return photoRepository.saveAndFlush(photo);
    }



}
