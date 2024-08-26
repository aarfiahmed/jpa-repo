package com.app.repository;

import com.app.entity.Student;

import java.util.List;

public interface Repository {
    void saveStudent(Student st);

    Student getStudentById(Long studentId);

    void updateStudentById(Student student);

    void removeStudent(Long studentId);

    List<String> findAllStudentNames();

    Student findStudentByName(String studentName);

    List<Student> findAllStudents();

}
