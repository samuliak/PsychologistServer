package com.samuliak.psychologist.server.service;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Journal;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientService {
    /*
    Данный сервис управляет всема функциями, которые можно сделать с клиентом
    а так же с его журналами (класс Journal)
     */
    List<Client> getAll();
    Client getById(int id);
    void remove(int id);
    void save(Client client);
    Client getByFirstName(@Param("name") String name);
    List<Journal> getAllJournalsById(int id);
    void saveJournal(Journal journal);
    void removeJournal(int id);
}
