package com.example.advSoft.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public  int id;
    @Column(name = "Subject")
    public  String subject;
    @Column(name = "Content")
    public  String content;
    @Column(name = "Language")
    public  String language;

    public Driver(int id, @JsonProperty("subject") String subject, @JsonProperty("content") String content, @JsonProperty("lang") String  language) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.language = language;
    }

    public Driver() {

    }


    public int getId() {
        return this.id;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getLanguage() {
        return this.language;
    }

    public String getContent() {
        return content;
    }
}
