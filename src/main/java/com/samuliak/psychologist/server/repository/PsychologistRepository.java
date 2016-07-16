package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PsychologistRepository extends CrudRepository<Psychologist, Integer>{
    Psychologist findByLogin(String login);
    @Query("select p from Psychologist p where name = ?1")
    List<Psychologist> findAllByName(String name);
    @Query("select p from Psychologist p where surname = ?1")
    List<Psychologist> findAllBySurname(String name);
}
