package com.dtubot.entity.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String textReport;
    private String timeReport;
    private String responseTime;
    private String respondent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextReport() {
        return textReport;
    }

    public void setTextReport(String textReport) {
        this.textReport = textReport;
    }

    public String getTimeReport() {
        return timeReport;
    }

    public void setTimeReport(String timeReport) {
        this.timeReport = timeReport;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }
}
