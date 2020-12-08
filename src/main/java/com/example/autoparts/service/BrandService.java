package com.example.AutoParts.service;

import com.example.AutoParts.model.Brand;

import java.util.Set;

public interface BrandService {

    Set<Brand> findAll();

    Brand findById(Long id);

    Brand findByName(String name);

    Brand save(Brand brand);

    Brand update(Brand brand);

    void deleteById(Long id);

}
