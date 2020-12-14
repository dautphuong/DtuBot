package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.service.IntentsService;
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
public class IntentsController {
    @Autowired
    IntentsService intentsService;

    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @PostMapping("/save-tag")
    public ResponseEntity<Intents> createProduct(@RequestBody Intents intents, UriComponentsBuilder builder) {
        intentsService.save(intents);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-intent/{id}").buildAndExpand(intents.getTag()).toUri());
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


}
