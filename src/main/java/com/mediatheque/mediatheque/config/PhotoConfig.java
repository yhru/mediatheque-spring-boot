package com.mediatheque.mediatheque.config;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PhotoConfig {

    @Bean
    CommandLineRunner commandLineRunner(PhotoRepository repository){
        return args -> {
            Photo photoConfig1 = new Photo(
                    "photoConfig1",
                    "resolutionConfig1",
                    "dataInPicture1"
            );

            Photo photoConfig2 = new Photo(
                    "photoConfig2",
                    "resolutionConfig2",
                    "dataInPicture2"
            );

            repository.saveAll(
                    List.of(photoConfig1, photoConfig2)
            );
        };
    }

}
