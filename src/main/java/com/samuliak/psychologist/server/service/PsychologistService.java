package com.samuliak.psychologist.server.service;

import com.samuliak.psychologist.server.entity.Field;
import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PsychologistService {
    /*
    Данный сервис управляет всема функциями, которые можно сделать с психологом
    а так же с его полями (класс Field)
     */
    List<Psychologist> getAll();
    Psychologist getById(int id);
    void remove(int id);
    void save(Psychologist psyh);
    Psychologist getByFirstName(@Param("name") String name);
    List<Field> getAllFieldsById(int id);
    void saveField(Field field);
    void removeField(int id);
}
