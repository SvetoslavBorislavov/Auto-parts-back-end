package com.example.AutoParts.service;

import com.example.AutoParts.model.Part;

import java.util.Set;

public interface PartService {
    void save(Part part);
    Part update (Part part);
    Part findById(Long id);
    Set<Part> findAll();
    void deleteById(Long id);
}
