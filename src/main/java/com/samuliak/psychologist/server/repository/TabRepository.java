package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Tab;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TabRepository extends CrudRepository<Tab, Integer> {
    @Query("select t from Tab t where t.doctor like :login")
    List<Tab> findAllByDoctor(@Param("login") String login);

    @Query("select t from Tab t where t.client like :login")
    List<Tab> findAllByClient(@Param("login") String login);
}
