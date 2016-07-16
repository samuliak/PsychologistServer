package com.samuliak.psychologist.server.controller;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Field;
import com.samuliak.psychologist.server.entity.Friends;
import com.samuliak.psychologist.server.entity.Psychologist;
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

    //   Получить список прошлых клиентов
    @RequestMapping(value = "/psychologist/exclient{login}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/friends/{login}", method = RequestMethod.GET)
    @ResponseBody
    public List<Friends> getAllFriendsByLogin(@PathVariable("login") String login){
        return service.getAllFriends(login);
    }

    /*
    Получить все запросы на дружбу
     */
    @RequestMapping(value = "/friends/request{login}", method = RequestMethod.GET)
    @ResponseBody
    public List<Friends> getAllFriendsRequestByLogin(@PathVariable("login") String login){
        return service.getAllFriendsRequest(login);
    }

    //Подтвердить дружбу
    @RequestMapping(value = "/friends/agree{id}", method = RequestMethod.GET)
    @ResponseBody
    public void agreeFriend(@PathVariable("id") int id){
        service.agreeFriend(id);
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

}