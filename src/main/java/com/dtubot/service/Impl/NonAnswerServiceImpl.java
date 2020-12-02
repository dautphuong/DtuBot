package com.dtubot.service.Impl;

import com.dtubot.entity.DAO.NonAnswer;
import com.dtubot.repository.NonAnswerRepository;
import com.dtubot.service.NonAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonAnswerServiceImpl implements NonAnswerService {
    @Autowired
    NonAnswerRepository nonAnswerRepository;

    @Override
    public List<NonAnswer> findAll() {
        return nonAnswerRepository.findAll();
    }

    @Override
    public NonAnswer findById(Integer id) {
        return nonAnswerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(NonAnswer nonAnswer) {
        nonAnswerRepository.save(nonAnswer);
    }

    @Override
    public void remove(Integer id) {
        nonAnswerRepository.deleteById(id);
    }

    @Override
    public List<NonAnswer> findNonAnswerByRespondentNotNull() {
        return nonAnswerRepository.findNonAnswerByRespondentNotNull();
    }

    @Override
    public List<NonAnswer> findNonAnswerByRespondentNull() {
        return nonAnswerRepository.findNonAnswerByRespondentNull();
    }
}
