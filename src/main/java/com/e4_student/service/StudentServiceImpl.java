package com.e4_student.service;

import com.e4_student.converter.StudentConverter;
import com.e4_student.dao.Student;
import com.e4_student.dao.StudentRepository;
import com.e4_student.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentByStudentId(long studentId) {
//        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        if (studentRepository.findByStudentId(studentDTO.getStudentId()).isPresent())
            throw new IllegalStateException("studentId: " + studentDTO.getStudentId() + " has already existed");
        else{
            Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
            return student.getStudentId();
        }

    }
}
