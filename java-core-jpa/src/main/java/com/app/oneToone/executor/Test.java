package com.app.oneToone.executor;

import com.app.oneToone.model.Employee;
import com.app.oneToone.model.Role;
import com.app.oneToone.repository.OneToOneRepository;

public class Test {
    private static final OneToOneRepository repo= new OneToOneRepository();
    private static final Long EMP_ID=3l;


    public static void main(String[] args) {
       // addEmp();
        getEmp();
    }

    static void addEmp(){
        Employee emp = new Employee("Raj",1000L,new Role("developer"));
        repo.addEmployee(emp);
    }

    static void getEmp(){
        System.out.println(repo.getEmployeeById(EMP_ID));
    }
}
