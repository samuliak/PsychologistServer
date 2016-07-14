package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FieldRepository extends CrudRepository<Field, Integer> {
    @Query("select f from Field f where psyh_id = ?1")
    List<Field> findAllByPsyhID(Integer psyh_ID);
}
