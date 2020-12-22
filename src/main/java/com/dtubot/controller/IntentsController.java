package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.service.IntentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IntentsController {
    @Autowired
    IntentsService intentsService;

    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @PostMapping("/save-tag")
    public ResponseEntity<Intents> createIntent(@RequestBody Intents intents, UriComponentsBuilder builder) {
        intentsService.save(intents);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/list-tag")
    public ResponseEntity<List<Intents>> getAllIntents() {
        return new ResponseEntity<>(intentsService.findAll(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/get-tag/{id}")
    public ResponseEntity<Intents> getTag(@PathVariable String id) {
        return new ResponseEntity<>(intentsService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @DeleteMapping("delete-tag/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        intentsService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save-list-tag")
    public void createListIntent(@RequestBody ArrayList<Intents> intents, UriComponentsBuilder builder) {
        for (Intents intent : intents) {
            createIntent(intent,builder);
        }
    }
}
