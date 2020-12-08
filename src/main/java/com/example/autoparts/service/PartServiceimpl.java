package com.example.AutoParts.service;

import com.example.AutoParts.exception.RecordNotFoundException;
import com.example.AutoParts.model.Part;
import com.example.AutoParts.repository.PartRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;


    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Set<Part> findAll() {
        return new HashSet<>(partRepository.findAll());
    }

    @Override
    public Part findById(Long id) {
        Optional<Part> part = partRepository.findById(id);
        return part.orElseThrow(() -> new RecordNotFoundException("Part not found with id: " + id));
    }

    @Override
    public Part findByName(String name) {
        Optional<Part> part = partRepository.findByName(name);
        return part.orElseThrow(() -> new RecordNotFoundException("Part with name : " + name + "does not exists"));
    }

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Part update(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void deleteById(Long id) {
        partRepository.deleteById(id);
    }
}
