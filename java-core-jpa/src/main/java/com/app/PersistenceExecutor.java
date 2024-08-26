package com.app;

import com.app.entity.Student;
import com.app.repository.Repository;
import com.app.repository.StudentRepository;

public class PersistenceExecutor {

    private static final Repository repo = new StudentRepository();
    private static final Long STUDENT_ID = 21L;


    public static void main(String[] args) {
         saveStudent();
        //getStudent();
      //  getAllStudentNames();
       // getStudentByName();
       // getAllStudents();
      //  updateStudent();
       // removeStudent();
    }


    private static void saveStudent() {
        Student student = new Student("X", "Java");
        repo.saveStudent(student);
    }

    private static void getStudent() {
        Student student = repo.getStudentById(STUDENT_ID);
        System.out.println(student);

    }

    private static void updateStudent() {
        Student st = new Student(STUDENT_ID, "KS", "php");
        repo.updateStudentById(st);
    }

    private static void removeStudent() {
        repo.removeStudent(STUDENT_ID);
    }

    private static void getAllStudentNames(){
        System.out.println("All Student names are ->");
        repo.findAllStudentNames().forEach(System.out::println);
    }

    private static void getStudentByName(){
        Student st=repo.findStudentByName("Raj");
        System.out.println(st);
    }

    private static void getAllStudents(){
        repo.findAllStudents().forEach(System.out::println);
    }

}
