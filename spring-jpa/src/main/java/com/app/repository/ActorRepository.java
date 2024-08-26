package com.app.repository;

import com.app.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<Actor,Long> {


    //Native Query example
    @Query(nativeQuery = true, value = "select a.id, a.name from actor a where a.name=:actorName")
    public Actor getActorByName(String actorName);


    @Query(value = "select new Actor(id , name) from Actor where id=:actorId")
    Actor getActorById(@Param("actorId")Long id);

    @Query(name = "getAllActorCount")
    Integer getAllActorCount();
}
