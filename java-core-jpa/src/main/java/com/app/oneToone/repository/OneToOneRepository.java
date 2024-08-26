package com.app.oneToone.repository;

import com.app.oneToone.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class OneToOneRepository {

    private final EntityManager entityManager;

    public OneToOneRepository( ) {
        this.entityManager = Persistence.createEntityManagerFactory("student-persistence").createEntityManager();
    }


    public void addEmployee(Employee emp){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(emp);
        transaction.commit();
    }

    public Employee getEmployeeById(Long id){
        return  entityManager.find(Employee.class,id);
    }
}
