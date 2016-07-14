package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Integer> {
    @Query("select j from Journal j where client_id = ?1")
    List<Journal> findAllByClientID(Integer client_id);
}
