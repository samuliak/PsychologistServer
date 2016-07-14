package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.repository.CrudRepository;

public interface PsychologistRepository extends CrudRepository<Psychologist, Integer>{
    Psychologist findByFirstName(String name);
}
