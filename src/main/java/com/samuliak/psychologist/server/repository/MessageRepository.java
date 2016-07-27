package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query("select m from Message m where m.tab_id =:id")
    List<Message> findAllByTabId(@Param("id") int id);
}
