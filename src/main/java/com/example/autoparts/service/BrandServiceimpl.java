package com.example.AutoParts.service;

import com.example.AutoParts.controller.exception.RecordNotFoundException;
import com.example.AutoParts.model.Brand;
import com.example.AutoParts.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class BrandServiceimpl implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceimpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Set<Brand> findAll() {
        return new HashSet<>(brandRepository.findAll());
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Brand not found with id: " + id));
    }

    public Brand findByName(String name) {
        return  brandRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException("Brand with name: " + name + "does not exists"));
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void deleteByBrand(String brand) {
        brandRepository.deleteByBrand(brand);
    }
}
