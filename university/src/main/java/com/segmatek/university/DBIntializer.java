package com.segmatek.university;

import com.segmatek.university.model.Score;
import com.segmatek.university.model.Student;
import com.segmatek.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBIntializer implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        Score score1 = new Score().withYear(2019).withBiology(90).withJava(35).withMath(80).withPhysics(80).withElectronics(80).withEnglish(95);
        Score score2 = new Score().withYear(2019).withBiology(55).withJava(95).withMath(88).withPhysics(55).withElectronics(60).withEnglish(95);
        Score score3 = new Score().withYear(2020).withBiology(85).withJava(75).withMath(96).withPhysics(98).withElectronics(90).withEnglish(70);
        Student s1 = new Student();
        Student s2  = new Student();
        s1.setFaculty("Medicine");
        s1.setStage(2);
        s1.setName("abdo ismaail");
        s1.setScores(Arrays.asList(score1));
        s2.setFaculty("engineering");
        s2.setStage(3);
        s2.setName("ahmed ali");
        s2.setScores(Arrays.asList(score2, score3));
        studentRepository.save(s1);
        studentRepository.save(s2);



    }

}
