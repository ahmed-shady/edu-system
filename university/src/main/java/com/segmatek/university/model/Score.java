package com.segmatek.university.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Score{
    @Id
    @GeneratedValue
    private Long id;
    private Integer year;
    private Integer math;
    private Integer physics;
    private Integer biology;
    private Integer java;
    private Integer english;
    private Integer electronics;

    public Score withYear(Integer year){
        this.year = year;
        return this;
    }

    public Score withMath(Integer math){
        this.math = math;
        return this;
    }
    public Score withPhysics(Integer physics){
        this.physics = physics;
        return this;
    }
    public Score withElectronics(Integer electronics){
        this.electronics = electronics;
        return this;
    }
    public Score withJava(Integer java){
        this.java = java;
        return this;
    }
    public Score withBiology(Integer biology){
        this.biology = biology;
        return this;
    }

    public Score withEnglish(Integer english){
        this.english = english;
        return this;
    }

}