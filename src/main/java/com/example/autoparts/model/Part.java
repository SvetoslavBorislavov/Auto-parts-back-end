package com.example.AutoParts.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String partName;

    @Column(nullable = false)
    private double price;

    @ToString.Exclude
    @ManyToOne
    @JoinTable(
            name = "part_name",
            joinColumns = @JoinColumn(name = "brand_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    private Brand brand;


}
