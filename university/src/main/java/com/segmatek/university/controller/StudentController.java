package com.segmatek.university.controller;

import com.segmatek.university.core.PostponeRequest;
import com.segmatek.university.core.StatusResponse;
import com.segmatek.university.model.Score;
import com.segmatek.university.model.Student;
import com.segmatek.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Value("${x.y}")
    String x_y;
    @PostMapping("/postpone")
    public StatusResponse postpone(@Valid  @RequestBody PostponeRequest req) {

        return studentService.getPostponeRequestStatus(req.getName());
    }

    @GetMapping("/{dashedName}")
    public Student getStudents(@PathVariable String dashedName) {
        String name = String.join(" ", dashedName.split("-"));
        return studentService.getStudentByName(name);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{dashedName}/scores")
    public List<Score> getStudentScore(@PathVariable String dashedName){
        String name = String.join(" ", dashedName.split("-"));
        return studentService.getScoresByName(name);
    }

    @GetMapping("/x_y")
    public String getXy(){
        return x_y;
    }


}
