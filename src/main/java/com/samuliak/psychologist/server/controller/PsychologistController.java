package com.samuliak.psychologist.server.controller;

import com.samuliak.psychologist.server.entity.*;
import com.samuliak.psychologist.server.repository.CurrentClientsRepository;
import com.samuliak.psychologist.server.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

        /*
        Работа с психологами
        */

    //   Получить всех психологов
    @RequestMapping(value = "/psychologist", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllPsychologist(){
        return service.getAll();
    }

    //   Получить всех психологов за параметрами
    @RequestMapping(value = "/psychologist/country{country}/city{city}/competence{competence}", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllPsychologistByParameters(@PathVariable("country") String country,
                                                             @PathVariable("city") String city,
                                                             @PathVariable("competence") String competence){
        return service.getAllByParameters(country, city, competence);
    }

    //   Получить рандомно 50 психологов
    @RequestMapping(value = "/psychologist/random", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllPsychologistRandom(){
        return service.getHalfHundredDoctors();
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


    /*
    Клиенты
     */
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


    //   Получить все запросы на дружбу, входные заявки
    @RequestMapping(value = "/friends/inputrequest/{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllFriendsRequestByLogin(@PathVariable("login") String login){
        return service.getAllFriendsInputRequest(login);
    }

    //   Получить все запросы на дружбу, исходные заявки
    @RequestMapping(value = "/friends/outputrequest/{login}", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllFriendsOutputRequest(@PathVariable("login") String login){
        return service.getAllFriendsOutputRequest(login);
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

    // Список доктороа, которые в онлайне
    @RequestMapping(value = "/psychologist/online", method = RequestMethod.POST)
    @ResponseBody
    public List<Psychologist> getAllDoctorWhoIsOnline(){
        return service.getAllDoctorsWhoIsOnline();
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

    //   Найти таб по логинам
    @RequestMapping(value = "/tab/client{client}/doctor{doctor}", method = RequestMethod.POST)
    @ResponseBody
    public Tab getTabByLogins(@PathVariable("client") String client,
                                        @PathVariable("doctor") String doctor){
        List<Tab> list = service.getAllTabByClient(client);
        for(Tab item : list){
            if (item.getDoctor().equals(doctor))
                return item;
        }
        return null;
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
    @RequestMapping(value = "/mes/save/text{text}/sender{sender},full{full_sender}/tab{tab}", method = RequestMethod.POST)
    @ResponseBody
    public void saveMessage(@PathVariable("text") String text, @PathVariable("sender") String sender,
                            @PathVariable("full_sender") String full_sender,
                            @PathVariable("tab") int tab){
        Message message = new Message();
        message.setText(text);
        message.setSender(sender);
        message.setFull_sender(full_sender);
        message.setTab_id(tab);
        service.saveMessage(message);
    }

    //   Получить все смс по табу
    @RequestMapping(value = "/mes/tab{id}/time{text}", method = RequestMethod.POST)
    @ResponseBody
    public List<Message> getUpdateMessage(@PathVariable("id") int id, @PathVariable("text") String text){
        List<Message> list = service.getAllMessageByTabId(id);
        if (list.get(list.size()-1).getText().equals(text)){
            return null;
        } else {
            for(int i=0; i<list.size(); i++){
                if (list.get(i).getText().equals(text)){
                    if (list.size()-1 == i) {
                        List<Message> ll = new ArrayList<Message>();
                        ll.add(list.get(i));
                        return ll;
                    }
                    else
                        return list.subList(i, list.size()-1);
                }
            }
        }
        return null;
    }

    //   Удалить смс
    @RequestMapping(value = "/mes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeMessage(@PathVariable("id") int id){
        service.removeMessage(id);
    }


    /*
    ФАЙЛЫ
     */
    @RequestMapping(value="/psychologist/upload", method=RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("description") RequestBody description,
                             @RequestParam MultipartFile file){
        String path = "";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                path = new File(description + "-uploaded").getPath();
                System.out.println(path);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(description + "-uploaded")));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("path > "+path);
        return path;
    }

}