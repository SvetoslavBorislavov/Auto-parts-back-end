package com.example.AutoParts.repository;

import com.example.AutoParts.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

  @Query(value = "SELECT p FROM Part p WHERE p .partName = ?1")
    Optional<Part> findByName(String name);
}
