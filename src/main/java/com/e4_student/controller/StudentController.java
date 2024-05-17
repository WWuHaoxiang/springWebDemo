package com.e4_student.controller;

import com.e4_student.dao.Student;
import com.e4_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }
}
