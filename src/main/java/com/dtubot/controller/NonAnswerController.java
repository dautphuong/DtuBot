package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.entity.DAO.NonAnswer;
import com.dtubot.service.NonAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class NonAnswerController {
    @Autowired
    NonAnswerService nonAnswerService;

    @PostMapping("/save-nonAnswer")
    public ResponseEntity<Intents> createProduct(@RequestBody NonAnswer nonAnswer, UriComponentsBuilder builder) {
        nonAnswerService.save(nonAnswer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-intent/{id}").buildAndExpand(nonAnswer.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list-nonAnswer")
    public ResponseEntity<List<NonAnswer>> getAllStatusAuction() {
        return new ResponseEntity<>(nonAnswerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-nonAnswer/{id}")
    public ResponseEntity<NonAnswer> getTag(@PathVariable Integer id) {
        return new ResponseEntity<>(nonAnswerService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete-nonAnswer/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        nonAnswerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
