package com.mediatheque.mediatheque;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.entities.User;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import com.mediatheque.mediatheque.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediathequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PhotoRepository photoRepository){
//		return args -> {
//			Photo premierTestFromIntelliJ = new Photo(
//					"TestName2",
//					"TestResolution2",
//					"TestDataInPicture3"
//			);
//			photoRepository.save(premierTestFromIntelliJ);
//		};
//	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			User addUser = new User(
					"Michel",
					true
			);
			userRepository.save(addUser);
		};
	}
}
