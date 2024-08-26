package com.app.repository;

import com.app.entity.Student;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

public class StudentRepository implements Repository {
    Logger log = Logger.getLogger(Student.class.getName());
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student-persistence");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void saveStudent(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public void updateStudentById(Student student) {

        Student dbStudent = entityManager.find(Student.class, student.getId());
        log.info("db student " + dbStudent);
        if (dbStudent != null) {
            dbStudent.setCourse(student.getCourse());
            dbStudent.setName(student.getName());
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            transaction.commit();
            log.info("Student updated into db");
        } else {
            log.info("student not found with id " + student.getId());
        }


    }

    @Override
    public void removeStudent(Long studentId) {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(student);
            transaction.commit();
            log.info("Student removed ");

        } else {
            log.info("student not found with id " + studentId);
        }

    }

    @Override
    public List<String> findAllStudentNames() {
        Query query = entityManager.createQuery("select s.name from Student s");
        return query.getResultList();
    }

    @Override
    public Student findStudentByName(String studentName) {
        Query namedQuery = entityManager.createNamedQuery("findStudentByName");
        namedQuery.setParameter("name",studentName);
        return  (Student) namedQuery.getSingleResult();
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> query = entityManager.createNamedQuery("findAllStudent", Student.class);
      return  query.getResultList();
    }


}
