package com.app.oneToone.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roleName;

    public Role() {

    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


}
