package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client findByLogin(String login);
    @Query("select c from Client c where c.name like :name")
    List<Client> findAllByName(@Param("name") String name);
    @Query("select c from Client c where c.surname like :name")
    List<Client> findAllBySurname(@Param("name")String name);
}
