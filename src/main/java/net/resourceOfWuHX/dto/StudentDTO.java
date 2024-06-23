package net.resourceOfWuHX.dto;

import lombok.Getter;

@Getter
public class StudentDTO {
    private long id;

    private String name;

    private long studentId;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
