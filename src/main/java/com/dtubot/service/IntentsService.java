package com.dtubot.service;

import com.dtubot.entity.DAO.Intents;

import java.util.List;

public interface IntentsService {
    List<Intents> findAll();

    Intents findById(String id);

    void save(Intents intents);

    void remove(String id);


}
