package com.rahul.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    
    // Constructor, getters and setters
    
    // One-to-many mapping with Marks
    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Marks> marks = new ArrayList<>();
}
