package com.app.repository;

import com.app.entity.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActorRepositoryTest {


    @Autowired
    ActorRepository repo;


    @Test
    void saveActor(){
        Actor actor = new Actor();
        actor.setName("Raj");
        repo.save(actor);
    }

    @Test
    void updateActor(){
    repo.save(new Actor(1L,"rahul"));
    }

    @Test
    void getActorCount(){
        System.out.println(repo.count());
    }

    @Test
    void getActorByName(){
        System.out.println(repo.getActorByName("rahul"));
    }

    @Test
    void getActorById(){
        System.out.println(repo.getActorById(1L));
    }

    @Test
    void getAllActorCount(){
        System.out.println(repo.getAllActorCount());
    }
}