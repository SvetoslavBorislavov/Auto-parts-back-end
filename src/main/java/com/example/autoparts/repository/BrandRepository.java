package com.example.AutoParts.repository;

import com.example.AutoParts.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "SELECT b FROM Brand p WHERE b .name = ?1")
    Optional<Brand> findByName(String name);
    void deleteByBrand(String brand);
}
