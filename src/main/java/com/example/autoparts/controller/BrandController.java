package com.example.AutoParts.controller;

import com.example.AutoParts.model.Brand;
import com.example.AutoParts.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Brand> findByName(@PathVariable String name) {
        return ResponseEntity.ok(brandService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody @Valid Brand brand) {
        Brand saveBrand = brandService.save(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBrand);
    }

    @PutMapping
    public ResponseEntity<Brand> update(@RequestBody @Valid Brand brand) {
        Brand updateBrand = brandService.update(brand);
        return ResponseEntity.ok(updateBrand);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
