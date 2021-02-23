package com.segmatek.scienceclub.model;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Scientist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String specialization;
    LocalDate birthDate;
    Integer registerationYear = LocalDate.now().getYear();
}
