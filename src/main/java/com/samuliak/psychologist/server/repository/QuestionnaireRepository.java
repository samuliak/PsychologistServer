package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Questionnaire;
import org.springframework.data.repository.CrudRepository;


public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Integer> {
    Questionnaire findByclientid(int id);
}
