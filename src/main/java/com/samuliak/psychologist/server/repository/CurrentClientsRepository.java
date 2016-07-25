package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.CurrentClients;
import org.springframework.data.repository.CrudRepository;

public interface CurrentClientsRepository extends CrudRepository<CurrentClients, Integer> {
}
