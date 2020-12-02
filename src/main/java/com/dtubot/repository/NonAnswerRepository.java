package com.dtubot.repository;

import com.dtubot.entity.DAO.NonAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NonAnswerRepository extends JpaRepository<NonAnswer, Integer> {
    List<NonAnswer> findNonAnswerByRespondentNotNull();
    List<NonAnswer> findNonAnswerByRespondentNull();

}
