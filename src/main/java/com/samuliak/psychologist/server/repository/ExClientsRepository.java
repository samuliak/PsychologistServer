package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.ExClients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExClientsRepository extends CrudRepository<ExClients, Integer> {
    @Query("select ec from ExClients ec where ec.doctor like :login")
    List<ExClients> findAllByDoctor(@Param("login")String login);
}
