package com.samuliak.psychologist.server.service;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Field;
import com.samuliak.psychologist.server.entity.Friends;
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
    Psychologist findByLogin(String login);
    List<Psychologist> findAllByName(@Param("name") String name);
    List<Psychologist> findAllBySurname(@Param("name") String name);
    List<Client> getListExClients(String login);
    List<Field> getAllFieldsById(int id);
    // Работа с друзьями
    List<Friends> getAllFriends(String login);
    List<Friends> getAllFriendsRequest(String login);
    void agreeFriend(int id);
    void saveField(Field field);
    void removeField(int id);
    // Онлайн
    void doctorOnlineFalse(String login);
}
