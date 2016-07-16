package com.samuliak.psychologist.server.service.Impl;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Field;
import com.samuliak.psychologist.server.entity.Friends;
import com.samuliak.psychologist.server.entity.Psychologist;
import com.samuliak.psychologist.server.repository.FieldRepository;
import com.samuliak.psychologist.server.repository.FriendsRepository;
import com.samuliak.psychologist.server.repository.PsychologistRepository;
import com.samuliak.psychologist.server.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsychologistServiceImpl implements PsychologistService {

    @Autowired
    private PsychologistRepository psRepository;

    @Autowired
    private FieldRepository fdRepository;

    @Autowired
    private FriendsRepository frRepository;

    public List<Psychologist> getAll() {
        List<Psychologist> list = new ArrayList<Psychologist>();
        for(Psychologist psychologist : psRepository.findAll()){
            list.add(psychologist);
        }
        return list;
    }

    public Psychologist getById(int id) {
        return psRepository.findOne(id);
    }

    public void remove(int id) {
        psRepository.delete(id);
    }

    public void save(Psychologist psyh) {
        psRepository.save(psyh);
    }

    public Psychologist findByLogin(String login) {
        Psychologist psychologist = psRepository.findByLogin(login);
        psychologist.setOnline(true);
        psRepository.save(psychologist);
        return psychologist;
    }

    public List<Psychologist> findAllByName(@Param("name") String name) {
        return psRepository.findAllByName(name);
    }

    public List<Psychologist> findAllBySurname(@Param("name") String name) {
        return psRepository.findAllBySurname(name);
    }

    public List<Client> getListExClients(String login) {
        return psRepository.findByLogin(login).getExClients();
    }


    public List<Field> getAllFieldsById(int id) {
        List<Field> list = new ArrayList<Field>();
        for(Field field : fdRepository.findAll()){
            list.add(field);
        }
        return list;
    }

    public List<Friends> getAllFriends(String login) {
        return frRepository.findAllFriendsByLogin(login);
    }

    public List<Friends> getAllFriendsRequest(String login) {
        return frRepository.findAllFriendsRequestByLogin(login);
    }

    public void agreeFriend(int id) {
        Friends friends = frRepository.findOne(id);
        friends.setFriend(true);
        frRepository.save(friends);
    }

    public void saveField(Field field) {
        fdRepository.save(field);
    }

    public void removeField(int id) {
        fdRepository.delete(id);
    }

    public void doctorOnlineFalse(String login) {
        Psychologist psychologist = psRepository.findByLogin(login);
        psychologist.setOnline(false);
        psRepository.save(psychologist);
    }
}
