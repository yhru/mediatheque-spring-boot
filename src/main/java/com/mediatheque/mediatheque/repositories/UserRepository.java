package com.mediatheque.mediatheque.repositories;

import com.mediatheque.mediatheque.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
