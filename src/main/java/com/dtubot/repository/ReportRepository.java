package com.dtubot.repository;

import com.dtubot.entity.DAO.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Integer> {
}
