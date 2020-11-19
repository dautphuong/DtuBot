package com.dtubot.service;

import com.dtubot.entity.DAO.NonAnswer;

import java.util.List;

public interface NonAnswerService {
    List<NonAnswer> findAll();

    NonAnswer findById(Integer id);

    void save(NonAnswer nonAnswer);

    void remove(Integer id);
}
