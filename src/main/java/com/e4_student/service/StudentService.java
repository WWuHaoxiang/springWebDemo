package com.e4_student.service;

import com.e4_student.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentByStudentId(long studentId);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentByStudentId(long studentId);

    StudentDTO updateStudentByStudentId(long studentId, String name, String email);
}
