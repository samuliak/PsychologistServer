package com.samuliak.psychologist.server.service.Impl;

import com.samuliak.psychologist.server.entity.*;
import com.samuliak.psychologist.server.repository.*;
import com.samuliak.psychologist.server.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PsychologistServiceImpl implements PsychologistService {

    @Autowired
    private PsychologistRepository psRepository;

    @Autowired
    private ClientRepository clRepository;

    @Autowired
    private FieldRepository fdRepository;

    @Autowired
    private FriendsRepository frRepository;

    @Autowired
    private CurrentClientsRepository ccRepository;

    @Autowired
    private ExClientsRepository ecRepository;

    @Autowired
    private TabRepository tabRepository;

    @Autowired
    private MessageRepository mesRepository;

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

    public List<Field> getAllFieldsById(int id) {
        List<Field> list = new ArrayList<Field>();
        for(Field field : fdRepository.findAll()){
            list.add(field);
        }
        return list;
    }


    /*
    Работа с друзьями
     */
    public List<Psychologist> getAllFriends(String login) {
        List<Friends> list = frRepository.findAllFriendsByLogin(login);
        return initListForFriendList(list);
    }

    public List<Psychologist> getAllFriendsRequest(String login) {
        List<Friends> list = frRepository.findAllFriendsRequestByLogin(login);
        return initListForFriendList(list);
    }

    public void createFriend(String log1, String log2) {
        Friends friends = new Friends(log1, log2);
        frRepository.save(friends);
    }

    private List<Psychologist> initListForFriendList(List<Friends> list) {
        List<Psychologist> doctors = new ArrayList<Psychologist>();
        Psychologist doctor;
        for(Friends item : list){
            doctor = psRepository.findByLogin(item.getDoctor_login_two());
            doctor.setPassword("");
            doctors.add(doctor);
        }
        return doctors;
    }

    public void agreeFriend(String log, String login) {
        List<Friends> list = frRepository.findAllFriendsRequestByLogin(log);
        for(Friends item : list){
            if (item.getDoctor_login_two().equals(login)){
                item.setFriend(true);
                frRepository.save(item);
            }
        }
    }

    public void deleteFriend(String log, String login) {
        List<Friends> list = frRepository.findAllFriendsRequestByLogin(log);
        for(Friends item : list){
            if (item.getDoctor_login_two().equals(login)){
                frRepository.delete(item.getID());
            }
        }

        List<Friends> list2 = frRepository.findAllFriendsByLogin(log);
        for(Friends item : list2){
            if (item.getDoctor_login_two().equals(login)){
                frRepository.delete(item.getID());
            }
        }
    }

    /*
    Работа с полями ( не все )
     */

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

    /*
    Методы для работы с клиентами
     */
    public List<Client> getAllClientsByDoctorLogin(String login) {
        List<Client> list = new ArrayList<Client>();
        for(CurrentClients item : ccRepository.findAll()){
            if (item.getDoctor().equals(login) && item.isClient()) {
                list.add(clRepository.findByLogin(item.getClient()));
            }
        }
        return list;
    }

    public List<Client> getListPotencialClients(String login) {
        List<Client> list = new ArrayList<Client>();
        for(CurrentClients item : ccRepository.findAll()){
            if (item.getDoctor().equals(login) && !item.isClient()) {
                list.add(clRepository.findByLogin(item.getClient()));
            }
        }
        return list;
    }

    public List<Client> getListExClients(String login) {
        List<Client> list = new ArrayList<Client>();
        for(ExClients item : ecRepository.findAll()){
            if (item.getDoctor().equals(login)) {
                list.add(clRepository.findByLogin(item.getClient()));
            }
        }
        return list;
    }

    public void saveClient(CurrentClients currentClients) {
        boolean bol = false;
        for(CurrentClients item : ccRepository.findAll()){
            if(currentClients.getClient().equals(item.getClient()))
                bol = true;
        }
        if (!bol)
            ccRepository.save(currentClients);
    }

    public void removeClient(String client_login) {
        CurrentClients currentClients = ccRepository.findByClient(client_login);
        ExClients exClients = new ExClients(currentClients.getDoctor(), currentClients.getClient());
        ecRepository.save(exClients);
        ccRepository.delete(currentClients);
    }

    /*
    Работа с табами
     */
    public List<Tab> getAllTabByDoctor(String login) {
        return tabRepository.findAllByDoctor(login);
    }

    public List<Tab> getAllTabByClient(String login) {
        return tabRepository.findAllByClient(login);
    }

    public void saveTab(Tab tab) {
        boolean bol = true;
        for(Tab item : tabRepository.findAll()){
            if (item.getDoctor().equals(tab.getDoctor())
                    && item.getClient().equals(tab.getClient()))
                bol = false;
        }
        if (bol)
            tabRepository.save(tab);
    }

    public void removeTab(int id) {
        tabRepository.delete(id);
    }


    /*
    Работа с смс
     */
    public List<Message> getAllMessageByTabId(int id) {
        return mesRepository.getAllMessageByTabId(id);
    }

    public void saveMessage(Message message) {
        mesRepository.save(message);
    }

    public void removeMessage(int id) {
        mesRepository.delete(id);
    }

}
