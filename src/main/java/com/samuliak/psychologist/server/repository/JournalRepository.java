package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Integer> {
    @Query("select j from Journal j where j.client like :login ORDER BY j.creation_date ASC ")
    List<Journal> findAllByClientAndSort(@Param("login")String login);
}
