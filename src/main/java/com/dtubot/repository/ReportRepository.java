package com.dtubot.repository;

import com.dtubot.entity.DAO.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {
    List<Report> findReportByRespondentNotNull();
    List<Report> findReportByRespondentNull();
}
