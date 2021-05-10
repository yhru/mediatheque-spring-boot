package com.mediatheque.mediatheque.repositories;

import com.mediatheque.mediatheque.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query(value = "select photo_id from photo_data_in_picture where data_in_picture_key LIKE :request", nativeQuery = true)
    public List<Map<String, Double>> findPhotoIdByDatas(@Param("request") String request);
}
