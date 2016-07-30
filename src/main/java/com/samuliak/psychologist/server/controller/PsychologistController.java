package com.samuliak.psychologist.server.controller;

import com.samuliak.psychologist.server.entity.*;
import com.samuliak.psychologist.server.repository.CurrentClientsRepository;
import com.samuliak.psychologist.server.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PsychologistController {

    /*
    Контролер для работы из психологом и полями. С его помощью достаем
    приложение сможет доставать информацию, которая нам нужна, например:
    поиск, поля, список психологов и т.д.
     */

    @Autowired
    private PsychologistService service;

    @Autowired
    private CurrentClientsRepository ccService;



    //   Получить всех психологов
    @RequestMapping(value = "/psychologist", method = RequestMethod.GET)
    @ResponseBody
    public List<Psychologist> getAllPsychologist(){
        return service.getAll();
    }

    //   Получить психолога по ID
    @RequestMapping(value = "/psychologist/id{id}", method = RequestMethod.GET)
    @ResponseBody
    public Psychologist getPsychologistById(@PathVariable("id") int psId){
        return service.getById(psId);
    }

    //   Получить психолога по логину
    @RequestMapping(value = "/psychologist/login{name}", method = RequestMethod.GET)
    @ResponseBody
    public Psychologist getPsychologistByLogin(@PathVariable("name") String psLogin){
        return service.findByLogin(psLogin);
    }

    //   Получить список психологов по имени
    @RequestMapping(value = "/psychologist/name{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Psychologist> getPsychologistByName(@PathVariable("name") String psLogin){
        return service.findAllByName(psLogin);
    }

    //   Получить список психологов по фамилии
    @RequestMapping(value = "/psychologist/surname{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Psychologist> getPsychologistBySurname(@PathVariable("name") String psLogin){
        return service.findAllBySurname(psLogin);
    }

    //   Сохранить психолога
    @RequestMapping(value = "/psychologist/save", method = RequestMethod.POST)
    @ResponseBody
    public void savePsychologist(@RequestBody Psychologist psychologist){
        service.save(psychologist);
    }

    //   Удалить психолога
    @RequestMapping(value = "/psychologist/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removePsychologist(@PathVariable("id") int psId){
        service.remove(psId);
    }

    //   Получить список потенциальных клиентов
    @RequestMapping(value = "/psychologist/potencial{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Client> getPotencialClients(@PathVariable("login") String login){
        return service.getListPotencialClients(login);
    }

    //   Подтвердить клиента
    @RequestMapping(value = "/psychologist/agree/{login}", method = RequestMethod.POST)
    @ResponseBody
    public void agreeClient(@PathVariable("login") String login){
        CurrentClients currentClients = ccService.findByClient(login);
        currentClients.setClient(true);
        ccService.save(currentClients);
    }

    //   Удалить клиента
    @RequestMapping(value = "/psychologist/delete/{login}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteClient(@PathVariable("login") String login){
        ccService.delete(ccService.findByClient(login).getID());

    }

    //   Получить список прошлых клиентов
    @RequestMapping(value = "/psychologist/exclient{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Client> getExClients(@PathVariable("login") String login){
        return service.getListExClients(login);
    }

    //   Получить все поля психолога по заданому логину
    @RequestMapping(value = "/field/{login}", method = RequestMethod.GET)
    @ResponseBody
    public List<Field> getAllFieldByLogin(@PathVariable("login") String login){
        int id = service.findByLogin(login).getID();
        return service.getAllFieldsById(id);
    }



    /*
    Получить всех друзей психолога
     */
    @RequestMapping(value = "/friends/{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllFriendsByLogin(@PathVariable("login") String login){
        return service.getAllFriends(login);
    }


    //   Получить все запросы на дружбу
    @RequestMapping(value = "/friends/request/{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllFriendsRequestByLogin(@PathVariable("login") String login){
        return service.getAllFriendsRequest(login);
    }

    // Добавить дружбу
    @RequestMapping(value = "/friends/first{log}/two{login}", method = RequestMethod.POST)
    @ResponseBody
    public void createFriend(@PathVariable("log") String log,
                                                          @PathVariable("login") String login){
        service.createFriend(log, login);
    }

    //   Подтвердить дружбу
    @RequestMapping(value = "/friends/agree{log}/two{login}", method = RequestMethod.POST)
    @ResponseBody
    public void agreeFriend(@PathVariable("log") String log,
                            @PathVariable("login") String login){
        service.agreeFriend(log, login);
    }

    // Удалить друга
    @RequestMapping(value = "/friends/delete{log}/two{login}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFriend(@PathVariable("log") String log,
                            @PathVariable("login") String login){
        service.deleteFriend(log, login);
    }


    //Выход из онлайна
    @RequestMapping(value = "/psychologist/online/false{login}", method = RequestMethod.POST)
    @ResponseBody
    public void doctorOnlineFalse(@PathVariable("login") String login){
        service.doctorOnlineFalse(login);
    }

    //   Сохранить поле
    @RequestMapping(value = "/field/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveField(@RequestBody Field field){
        service.saveField(field);
    }

    //   Удалить поле
    @RequestMapping(value = "/field/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeField(@PathVariable("id") int psId){
        service.removeField(psId);
    }

    /*
    Работа с табами
     */

    //   Получить все табы по доктору
    @RequestMapping(value = "/tab/doctor{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tab> getAllTabsByDoctor(@PathVariable("login") String login){
        return service.getAllTabByDoctor(login);
    }

    //   Получить все табы по клиенту
    @RequestMapping(value = "/tab/client{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tab> getAllTabsByClient(@PathVariable("login") String login){
        return service.getAllTabByClient(login);
    }

    //   Сохранить таб
    @RequestMapping(value = "/tab/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveTab(@RequestBody Tab tab){
        service.saveTab(tab);
    }

    //   Удалить таб
    @RequestMapping(value = "/tab/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTab(@PathVariable("id") int id){
        service.removeTab(id);
    }


    /*
    Работа с смс
     */

    //   Получить все смс по табу
    @RequestMapping(value = "/mes/tab{id}", method = RequestMethod.POST)
    @ResponseBody
    public List<Message> getAllMessageByTab(@PathVariable("id") int id){
        return service.getAllMessageByTabId(id);
    }

    //   Сохранить смс
    @RequestMapping(value = "/mes/save/text{text}/sender{sender}/tab{tab}", method = RequestMethod.POST)
    @ResponseBody
    public void saveMessage(@PathVariable("text") String text, @PathVariable("sender") String sender,
                            @PathVariable("tab") int tab){
        Message message = new Message();
        message.setText(text);
        message.setSender(sender);
        message.setTab_id(tab);
        service.saveMessage(message);
    }

    //   Удалить смс
    @RequestMapping(value = "/mes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeMessage(@PathVariable("id") int id){
        service.removeMessage(id);
    }
}