package com.example.graphql.repository;

import com.example.graphql.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaptopRepository extends JpaRepository<Laptop, UUID> {

}
