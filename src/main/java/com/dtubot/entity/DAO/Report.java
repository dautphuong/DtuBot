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
    private String questionGuest;
    private String answerError;
    private String dayTime;
    private String respondent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerError() {
        return answerError;
    }

    public void setAnswerError(String answerError) {
        this.answerError = answerError;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public String getQuestionGuest() {
        return questionGuest;
    }

    public void setQuestionGuest(String questionGuest) {
        this.questionGuest = questionGuest;
    }
}
