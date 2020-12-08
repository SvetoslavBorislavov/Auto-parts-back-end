package com.example.AutoParts.service;

import com.example.AutoParts.controller.exception.RecordNotFoundException;
import com.example.AutoParts.model.Part;
import com.example.AutoParts.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PartServiceimpl implements PartService{
    private PartRepository partRepository;


    @Autowired
    public PartServiceimpl(PartRepository partRepository){
        this.partRepository = partRepository;
    }

    @Override
    public void save(Part part) { partRepository.save(part); }

    @Override
    public Part update (Part part) {return  null;}

    public Part findByName(String name) {
        Optional<Part> part = partRepository.findByName(name);
        return part.orElseThrow(() -> new RecordNotFoundException("Part with name : " + name + "does not exists"));
    }

    @Override
    public Part findById(Long id) {
        Optional<Part>part = partRepository.findById(id);
        return part.orElseThrow(() -> new RecordNotFoundException("Part not found with id: " + id));
    }

    @Override
    public Set<Part>findAll(){return new HashSet<>(partRepository.findAll());
    }
    @Override
    public void deleteById(Long id) {partRepository.deleteById(id);}
}
