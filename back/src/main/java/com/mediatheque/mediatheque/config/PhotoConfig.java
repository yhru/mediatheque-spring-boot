//package com.mediatheque.mediatheque.config;
//
//import ai.djl.ModelException;
//import ai.djl.modality.cv.output.DetectedObjects;
//import ai.djl.translate.TranslateException;
//import com.mediatheque.mediatheque.DJL.ObjectDetection;
//import com.mediatheque.mediatheque.entities.Photo;
//import com.mediatheque.mediatheque.repositories.PhotoRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class PhotoConfig {
//
//
//
//    @Bean
//    CommandLineRunner commandLineRunner(PhotoRepository repository) throws ModelException, TranslateException, IOException {
//        DetectedObjects test = ObjectDetection.predict();
//        System.out.println(test);
//        return args -> {
//            Photo photoConfig1 = new Photo(
//                    "photoConfig1",
//                    "resolutionConfig1",
//                    test.toString()
//            );
//
//            Photo photoConfig2 = new Photo(
//                    "photoConfig2",
//                    "resolutionConfig2",
//                    test.toString()
//            );
//
//            repository.saveAll(
//                    List.of(photoConfig1, photoConfig2)
//            );
//        };
//    }
//
//}
