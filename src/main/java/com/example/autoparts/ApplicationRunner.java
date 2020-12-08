package com.example.AutoParts;

import com.example.AutoParts.model.Brand;
import com.example.AutoParts.model.Part;
import com.example.AutoParts.repository.BrandRepository;
import com.example.AutoParts.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public class ApplicationRunner implements CommandLineRunner {


    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private PartRepository partRepository;

    @Autowired
    public ApplicationRunner(BrandRepository brandRepository, PartRepository partRepository) {
        this.brandRepository = brandRepository;
        this.partRepository = partRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Brand brandFirst = new Brand();
        brandFirst.setName("AutoCraft");
        brandRepository.save(brandFirst);


        Part partFirst = new Part();
        partFirst.setPartName("Kolqnov val");
        partFirst.setPrice(150.00);
        partRepository.save(partFirst);

        List<Brand> brands = brandRepository.findAll();

        for (Brand brand : brands) {
            System.out.println(brand.toString());
        }

    }
}
