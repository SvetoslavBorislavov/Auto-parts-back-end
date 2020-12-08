package com.example.AutoParts.controller;

import com.example.AutoParts.model.Brand;
import com.example.AutoParts.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    private BrandService brandService;

    @Autowired
public BrandController(BrandService brandService) {this.brandService = brandService;}

    @GetMapping(value = "/id")
    public ResponseEntity<Set<Brand>> findById() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping(value =  "/brand/{brand}")
    public ResponseEntity<Brand>findByName(@PathVariable String name) {
        return ResponseEntity.ok(brandService.findByName(name));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/brand/{brand}")
    public ResponseEntity<HttpStatus> deleteByBrand(@PathVariable String brand) {
        brandService.deleteByBrand(brand);
        return ResponseEntity.ok().build();
    }
}
