package com.samuliak.psychologist.server.service.Impl;


import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Journal;
import com.samuliak.psychologist.server.entity.Questionnaire;
import com.samuliak.psychologist.server.repository.ClientRepository;
import com.samuliak.psychologist.server.repository.JournalRepository;
import com.samuliak.psychologist.server.repository.PsychologistRepository;
import com.samuliak.psychologist.server.repository.QuestionnaireRepository;
import com.samuliak.psychologist.server.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clRepository;

    @Autowired
    private PsychologistRepository psRepository;

    @Autowired
    private QuestionnaireRepository qsRepository;

    @Autowired
    private JournalRepository jlRepository;

    public List<Client> getAll() {
        List<Client> list = new ArrayList<Client>();
        for(Client client : clRepository.findAll()){
            list.add(client);
        }
        return list;
    }

    public Client getById(int id) {
        return clRepository.findOne(id);
    }

    public void remove(int id) {
        clRepository.delete(id);
    }

    public void save(Client client) {
        clRepository.save(client);
    }


    public Client findByLogin(String login) {
        return clRepository.findByLogin(login);
    }

    public List<Client> findAllByName(@Param("name") String name) {
        return clRepository.findAllByName(name);
    }

    public List<Client> findAllBySurname(@Param("name") String name) {
        return clRepository.findAllBySurname(name);
    }

    /*
    Анкета
     */

    public Questionnaire getQuestionnaireByLogin(String login) {
        return qsRepository.findByclient(login);
    }

    public void saveQuestionnaire(Questionnaire questionnaire) {
        qsRepository.save(questionnaire);
    }

    public void removeQuestionnaireByClientLogin(String login) {
        qsRepository.delete(qsRepository.findByclient(login).getID());
    }

    /*
    Журнал
     */

    public List<Journal> getAllJournalsByLogin(String login) {
        return jlRepository.findAllByClientAndSort(login);
    }

    public void saveJournal(Journal journal) {
        jlRepository.save(journal);
    }

}
