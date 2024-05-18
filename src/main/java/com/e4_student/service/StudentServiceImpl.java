package com.e4_student.service;

import com.e4_student.converter.StudentConverter;
import com.e4_student.dao.Student;
import com.e4_student.dao.StudentRepository;
import com.e4_student.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public void deleteStudentByStudentId(long studentId) {
        studentRepository.findByStudentId(studentId).orElseThrow(() -> new IllegalStateException("studentId: " + studentId + " does not exist"));
        studentRepository.deleteByStudentId(studentId);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentByStudentId(long studentId, String name, String email) {
        Student studentInDB = studentRepository.findByStudentId(studentId).orElseThrow(() -> new IllegalStateException("studentId: " + studentId + " does not exist"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getName().equals(email)){
            studentInDB.setName(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }
}
