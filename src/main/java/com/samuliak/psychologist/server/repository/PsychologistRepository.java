package com.samuliak.psychologist.server.repository;


import com.samuliak.psychologist.server.entity.Psychologist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PsychologistRepository extends CrudRepository<Psychologist, Integer>{
    Psychologist findByLogin(String login);
    @Query("select p from Psychologist p where p.name like :name")
    List<Psychologist> findAllByName(@Param("name")String name);
    @Query("select p from Psychologist p where p.surname like :name")
    List<Psychologist> findAllBySurname(@Param("name")String name);

    @Query("select p from Psychologist p where p.online = true")
    List<Psychologist> getAllDoctorsWhoIsOnline();

    @Query("select p from Psychologist p where p.country like :country and p.city like :city and p.competence like :competence")
    List<Psychologist> findByCountryCityCompetence(@Param("country") String country,
                                                   @Param("city") String city, @Param("competence") String competence);

    @Query("select p from Psychologist p where p.country like :country and p.city like :city")
    List<Psychologist> findByCountryCity(@Param("country") String country,
                                         @Param("city") String city);

    @Query("select p from Psychologist p where p.country like :country and p.competence like :competence")
    List<Psychologist> findByCountryCompetence(@Param("country") String country,
                                               @Param("competence") String competence);

    @Query("select p from Psychologist p where p.city like :city and p.competence like :competence")
    List<Psychologist> findByCityCompetence(@Param("city") String city,
                                               @Param("competence") String competence);

    @Query("select p from Psychologist p where p.competence like :competence")
    List<Psychologist> findByCompetence(@Param("competence") String competence);

    @Query("select p from Psychologist p where p.country like :country")
    List<Psychologist> findByCountry(@Param("country") String country);

    @Query("select p from Psychologist p where p.city like :city")
    List<Psychologist> findByCity(@Param("city") String city);
}
