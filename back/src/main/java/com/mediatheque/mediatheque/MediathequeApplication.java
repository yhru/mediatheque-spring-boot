package com.mediatheque.mediatheque;

import ai.djl.ModelException;
import ai.djl.translate.TranslateException;
import com.mediatheque.mediatheque.DJL.ObjectDetection;
import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.entities.User;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import com.mediatheque.mediatheque.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class MediathequeApplication {

	public static void main(String[] args) throws ModelException, TranslateException, IOException {
		SpringApplication.run(MediathequeApplication.class, args);
	}

}
