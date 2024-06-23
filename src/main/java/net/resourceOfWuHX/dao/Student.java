package net.resourceOfWuHX.dao;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
