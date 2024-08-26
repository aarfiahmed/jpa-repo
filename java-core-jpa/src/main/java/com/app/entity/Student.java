package com.app.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findStudentByName", query = "select  new Student(s.id, s.name, s.course) from Student s where s.name=:name")
@NamedQuery(name="findAllStudent", query=" from Student")
public class Student {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String course;


public Student(){

}
    public Student(Long id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student(  String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
