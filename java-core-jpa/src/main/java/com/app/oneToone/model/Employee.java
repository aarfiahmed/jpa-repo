package com.app.oneToone.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long salary;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    Role role;

    public Employee(){

    }

    public Employee( String name, Long salary, Role role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public Employee(Long id, String name, Long salary, Role role) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }
}
