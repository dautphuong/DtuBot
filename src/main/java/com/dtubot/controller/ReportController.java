package com.dtubot.controller;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.entity.DAO.NonAnswer;
import com.dtubot.entity.DAO.Report;
import com.dtubot.service.NonAnswerService;
import com.dtubot.service.ReportService;
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
public class ReportController {
    @Autowired
    ReportService reportService;
    @PostMapping("/save-report")
    public ResponseEntity<Intents> createReport(@RequestBody Report report, UriComponentsBuilder builder) {
        reportService.save(report);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-intent/{id}").buildAndExpand(report.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/list-report")
    public ResponseEntity<List<Report>> getListReport() {
        return new ResponseEntity<>(reportService.findReportByRespondentNull(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/get-report/{id}")
    public ResponseEntity<Report> getReport(@PathVariable Integer id) {
        return new ResponseEntity<>(reportService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @DeleteMapping("delete-report/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        reportService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @GetMapping("/list-report-history")
    public ResponseEntity<List<Report>> getHisReport() {
        return new ResponseEntity<>(reportService.findReportByRespondentNotNull(), HttpStatus.OK);
    }
}
