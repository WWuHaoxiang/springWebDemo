package com.e4_student.service;

import com.e4_student.dao.Student;
import com.e4_student.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentByStudentId(long studentId);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentByStudentId(long studentId);
}
