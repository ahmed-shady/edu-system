package com.segmatek.university.service;

import com.segmatek.university.core.StatusResponse;
import com.segmatek.university.exception.ResourceNotFoundException;
import com.segmatek.university.model.Score;
import com.segmatek.university.model.Student;
import com.segmatek.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public Student getStudentByName(String name){
        Student s = studentRepository.findByName(name);
        if(s == null)
            throw new ResourceNotFoundException("student is not recorded");
        return s;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public StatusResponse getPostponeRequestStatus(String name){
        if(studentRepository.existsByName(name)){
            return new StatusResponse("accepted");
        }else{
            return new StatusResponse("rejected");
        }
    }

    public List<Score> getScoresByName(String name){
        Student s = studentRepository.findByName(name);
        if(s == null)
            throw new ResourceNotFoundException("student is not recorded");
        return s.getScores();
    }
}
