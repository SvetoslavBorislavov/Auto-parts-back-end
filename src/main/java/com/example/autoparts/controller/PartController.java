package com.example.AutoParts.controller;

import com.example.AutoParts.model.Brand;
import com.example.AutoParts.model.Part;
import com.example.AutoParts.service.BrandService;
import com.example.AutoParts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/part")
public class PartController {
    private PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Part> findById(@PathVariable Long id) {
        return ResponseEntity.ok(partService.findById(id));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Part> findByName(@PathVariable String name) {
        return ResponseEntity.ok(partService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Part> save(@RequestBody @Valid Part part) {
        Part savePart = partService.save(part);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePart);
    }

    @PutMapping
    public ResponseEntity<Part> update(@RequestBody @Valid Part part) {
        Part updatePart = partService.update(part);
        return ResponseEntity.ok(updatePart);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        partService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
