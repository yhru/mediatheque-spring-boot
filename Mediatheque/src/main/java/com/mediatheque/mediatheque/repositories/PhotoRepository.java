package com.mediatheque.mediatheque.repositories;

import com.mediatheque.mediatheque.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
