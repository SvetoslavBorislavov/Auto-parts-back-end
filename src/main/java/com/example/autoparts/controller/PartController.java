package com.example.AutoParts.controller;

import com.example.AutoParts.model.Brand;
import com.example.AutoParts.model.Part;
import com.example.AutoParts.service.BrandService;
import com.example.AutoParts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/part")
public class PartController {
    private PartService partService;
    @Autowired
    public PartController(PartService partService) {this.partService = partService;}

    @GetMapping(value = "/id")
    public ResponseEntity<Part> findById(@PathVariable Long id) {
        return ResponseEntity.ok(partService.findById(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        partService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
