package net.resourceOfWuHX.converter;

import net.resourceOfWuHX.dao.Student;
import net.resourceOfWuHX.dto.StudentDTO;

public class StudentConverter {

    public static StudentDTO convertStudent(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setEmail(student.getEmail());
        studentDTO.setId(student.getId());
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        return studentDTO;
    }

    public static Student convertStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setStudentId(studentDTO.getStudentId());
        return student;
    }

}
