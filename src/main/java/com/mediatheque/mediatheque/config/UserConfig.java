package com.mediatheque.mediatheque.config;

import com.mediatheque.mediatheque.entities.Photo;
import com.mediatheque.mediatheque.entities.User;
import com.mediatheque.mediatheque.repositories.PhotoRepository;
import com.mediatheque.mediatheque.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            User userConfig1 = new User(
                    "userConfig1",
                    true
            );

            User userConfig2 = new User(
                    "userConfig2",
                    false
            );

            repository.saveAll(
                    List.of(userConfig1, userConfig2)
            );
        };
    }

}
