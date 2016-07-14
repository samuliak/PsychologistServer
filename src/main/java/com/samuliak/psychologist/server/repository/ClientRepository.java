package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client findByFirstName(String name);
}
