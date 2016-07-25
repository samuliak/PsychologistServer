package com.samuliak.psychologist.server.service;

import com.samuliak.psychologist.server.entity.*;
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
    List<Field> getAllFieldsById(int id);
    // Работа с друзьями
    List<Friends> getAllFriends(String login);
    List<Friends> getAllFriendsRequest(String login);
    void agreeFriend(int id);
    void saveField(Field field);
    void removeField(int id);
    // Онлайн
    void doctorOnlineFalse(String login);
    // Работа с текущими клиентами
    List<Client> getAllClientsByDoctorLogin(String login);
    List<Client> getListPotencialClients(String login);
    void saveClient(CurrentClients currentClients);
    void removeClient(String client_login);
}
