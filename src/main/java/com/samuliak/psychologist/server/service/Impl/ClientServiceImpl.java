package com.samuliak.psychologist.server.service.Impl;


import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Journal;
import com.samuliak.psychologist.server.repository.ClientRepository;
import com.samuliak.psychologist.server.repository.JournalRepository;
import com.samuliak.psychologist.server.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clRepository;

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

    public Client getByFirstName(@Param("name") String name) {
        return clRepository.findByFirstName(name);
    }

    public List<Journal> getAllJournalsById(int id) {
        List<Journal> list = new ArrayList<Journal>();
        for(Journal journal : jlRepository.findAll()){
            list.add(journal);
        }
        return list;
    }

    public void saveJournal(Journal journal) {
        jlRepository.save(journal);
    }

    public void removeJournal(int id) {
        jlRepository.delete(id);
    }
}
