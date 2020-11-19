package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.service.IntentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class IntentsController {
    @Autowired
    IntentsService intentsService;

    @PostMapping("/save")
    public ResponseEntity<Intents> createProduct(@RequestBody Intents intents, UriComponentsBuilder builder) {
        intentsService.save(intents);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-intent/{id}").buildAndExpand(intents.getTag()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Intents>> getAllStatusAuction() {
        return new ResponseEntity<>(intentsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getTag/{id}")
    public ResponseEntity<Intents> getTag(@PathVariable String id) {
        return new ResponseEntity<>(intentsService.findById(id), HttpStatus.OK);
    }
}
