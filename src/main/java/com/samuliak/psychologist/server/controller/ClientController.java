package com.samuliak.psychologist.server.controller;

import com.samuliak.psychologist.server.entity.Client;
import com.samuliak.psychologist.server.entity.Journal;
import com.samuliak.psychologist.server.entity.Psychologist;
import com.samuliak.psychologist.server.entity.Questionnaire;
import com.samuliak.psychologist.server.service.ClientService;
import com.samuliak.psychologist.server.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    /*
    Контролер для работы из клиентами, журналами и анкетами. С его помощью достаем
    приложение сможет доставать информацию, которая нам нужна, например:
    поиск, журналы, список клиентов и т.д.
     */

    @Autowired
    private ClientService serviceCl;
    @Autowired
    private PsychologistService servicePs;

    //   Получить всех клиентов
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getAllClient(){
        return serviceCl.getAll();
    }

    //   Получить клиента по ID
    @RequestMapping(value = "/client/id{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") int clId){
        return serviceCl.getById(clId);
    }

    //   Получить клиента по логину
    @RequestMapping(value = "/client/login{name}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClientByLogin(@PathVariable("name") String clLogin){
        return serviceCl.findByLogin(clLogin);
    }

    //   Получить список клиентов за именем
    @RequestMapping(value = "/client/name{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClientByName(@PathVariable("name") String clLogin){
        return serviceCl.findAllByName(clLogin);
    }

    //   Получить список клиентов за фамилией
    @RequestMapping(value = "/client/surname{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClientBySurname(@PathVariable("name") String clLogin){
        return serviceCl.findAllBySurname(clLogin);
    }

    //   Сохранить клиента
    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveClient(@RequestBody Client client){
        serviceCl.save(client);
    }

    //   Удалить клиента
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeClient(@PathVariable("id") int id){
        serviceCl.remove(id);
    }


    //   Назначить врача клиенту
    @RequestMapping(value = "/client/psadd/client{id}/login{login}", method = RequestMethod.GET)
    @ResponseBody
    public void setPsychologistClient(@PathVariable("id") int id, @PathVariable("login") String login){
        serviceCl.savePsychologist(id, login);
    }

    /*
    Удалить психолога клиента
    Так же паралельно добавляет клиента в список exClients психологу
     */
    @RequestMapping(value = "/client/psremove{id}", method = RequestMethod.GET)
    @ResponseBody
    public void removePsychologistClient(@PathVariable("id") int id){
        Psychologist doctor = serviceCl.getById(id).getDoctor();
        doctor.addClientForListExClients(serviceCl.getById(id));
        serviceCl.removePsychologist(id);
    }

    /*
    Список клиентов по психологу заданым логином
    Используется в меню психолога, когда он хочет посмотреть своих клиентов
     */
    @RequestMapping(value = "/client/doctor/login{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClientsByDoctorLogin(@PathVariable("name") String psLogin){
        return serviceCl.findAllByDoctor(psLogin);
    }

    //   Получить все журналы по логину
    @RequestMapping(value = "/client/journal{login}", method = RequestMethod.GET)
    @ResponseBody
    public List<Journal> getAllJournalsByLogin(@PathVariable("login") String login){
        return serviceCl.getAllJournalsByLogin(login);
    }

    //   Сохранить журнал
    @RequestMapping(value = "/journal/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveJournal(@RequestBody Journal journal){
        serviceCl.saveJournal(journal);
    }

    //   Удалить журнал
    @RequestMapping(value = "/journal/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeJournal(@PathVariable("id") int id){
        serviceCl.removeJournal(id);
    }


    //   Сохранить анкету
    @RequestMapping(value = "/questionnaire/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveJournal(@RequestBody Questionnaire questionnaire){
        serviceCl.saveQuestionnaire(questionnaire);
    }

    //   Удалить анкету
    @RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeQuestionnaire(@PathVariable("id") int id){
        serviceCl.removeQuestionnaireByClientId(id);
    }
}
