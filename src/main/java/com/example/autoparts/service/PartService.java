package com.example.AutoParts.service;

import com.example.AutoParts.model.Part;

import java.util.Set;

public interface PartService {
    Set<Part> findAll();

    Part findById(Long id);

    Part findByName(String name);

    Part save(Part part);

    Part update(Part part);

    void deleteById(Long id);
}
