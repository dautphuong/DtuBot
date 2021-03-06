package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.entity.DAO.NonAnswer;
import com.dtubot.service.NonAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class NonAnswerController {
    @Autowired
    NonAnswerService nonAnswerService;
    @PostMapping("/save-nonAnswer")
    public ResponseEntity<Intents> createNonAnswer(@RequestBody NonAnswer nonAnswer, UriComponentsBuilder builder) {
        nonAnswerService.save(nonAnswer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-intent/{id}").buildAndExpand(nonAnswer.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/list-nonAnswer")
    public ResponseEntity<List<NonAnswer>> getAllNonAnswer() {
        return new ResponseEntity<>(nonAnswerService.findNonAnswerByRespondentNull(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/get-nonAnswer/{id}")
    public ResponseEntity<NonAnswer> getNonAnswer(@PathVariable Integer id) {
        return new ResponseEntity<>(nonAnswerService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete-nonAnswer/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        nonAnswerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/list-nonAnswer-report")
    public ResponseEntity<List<NonAnswer>> getHisNonAnswer() {
        return new ResponseEntity<>(nonAnswerService.findNonAnswerByRespondentNotNull(), HttpStatus.OK);
    }
}
