package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client findByLogin(String login);
    @Query("select c from Client c where name = ?1")
    List<Client> findAllByName(String name);
    @Query("select c from Client c where surname = ?1")
    List<Client> findAllBySurname(String name);
    @Query("select c from Client c where psychologist = ?1")
    List<Client> findAllByDoctor(String psychologist);
}
