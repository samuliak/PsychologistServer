package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PsychologistRepository extends CrudRepository<Psychologist, Integer>{
    Psychologist findByLogin(String login);
    @Query("select p from Psychologist p where p.name like :name")
    List<Psychologist> findAllByName(@Param("name")String name);
    @Query("select p from Psychologist p where p.surname like :name")
    List<Psychologist> findAllBySurname(@Param("name")String name);

    @Query("select p from Psychologist p where p.online = true")
    List<Psychologist> getAllDoctorsWhoIsOnline();
}
