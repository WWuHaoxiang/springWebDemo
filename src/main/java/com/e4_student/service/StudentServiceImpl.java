package com.e4_student.service;

import com.e4_student.dao.Student;
import com.e4_student.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(long id) {
//        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return studentRepository.findByStudentId(id).orElseThrow(RuntimeException::new);
    }
}
