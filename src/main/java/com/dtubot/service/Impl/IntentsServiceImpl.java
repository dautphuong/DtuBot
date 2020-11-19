package com.dtubot.service.Impl;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.repository.IntentsRepository;
import com.dtubot.service.IntentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IntentsServiceImpl implements IntentsService {
    @Autowired
    IntentsRepository intentsRepository;
    @Override
    public List<Intents> findAll() {
        return intentsRepository.findAll();
    }

    @Override
    public Intents findById(String id) {
        return intentsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Intents intents) {
        intentsRepository.save(intents);
    }

    @Override
    public void remove(String id) {
        intentsRepository.deleteById(id);
    }
}
