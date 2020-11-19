package com.dtubot.service;

import com.dtubot.entity.DAO.Report;

import java.util.List;

public interface ReportService {
    List<Report> findAll();

    Report findById(Integer id);

    void save(Report report);

    void remove(Integer id);
}
