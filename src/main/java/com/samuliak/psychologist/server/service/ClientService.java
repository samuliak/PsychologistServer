package com.samuliak.psychologist.server.service;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Journal;
import com.samuliak.psychologist.server.entity.Questionnaire;
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
    void savePsychologist(int idClient, String login);
    void removePsychologist(int idClient);
    Client findByLogin(String login);
    List<Client> findAllByName(@Param("name") String name);
    List<Client> findAllBySurname(@Param("name") String name);
    List<Journal> getAllJournalsByLogin(String id);
    void saveJournal(Journal journal);
    void removeJournal(int id);
    void saveQuestionnaire(Questionnaire questionnaire);
    void removeQuestionnaireByClientId(int id);
}
