package com.segmatek.university.model;

import com.segmatek.university.model.Score;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String faculty;
    private Integer stage;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private List<Score> scores = new ArrayList<>();
}