package com.dtubot.service.Impl;

import com.dtubot.entity.DAO.Report;
import com.dtubot.repository.ReportRepository;
import com.dtubot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report findById(Integer id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void remove(Integer id) {
        reportRepository.deleteById(id);
    }

    @Override
    public List<Report> findReportByRespondentNotNull() {
        return reportRepository.findReportByRespondentNotNull();
    }

    @Override
    public List<Report> findReportByRespondentNull() {
        return reportRepository.findReportByRespondentNull();
    }
}
