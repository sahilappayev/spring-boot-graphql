package com.example.graphql.repository;

import com.example.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> getAllByNameLike(String name);

    User findByName(String name);
}
