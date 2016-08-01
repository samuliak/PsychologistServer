package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query("select m from Message m where m.tab_id =:tab ORDER BY m.creation_date ASC ")
    List<Message> getAllMessageByTabId(@Param("tab") int tab);
}
