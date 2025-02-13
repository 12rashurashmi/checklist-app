package com.example.checklist.model;

public class Checklist {
    private String question;
    private String response; // yes, no, na
    private String comment;
    private String attachment;
    private String responderName; // New field for responder's name
    private int responderAge; // New field for responder's age

    // Getters and Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getResponderName() {
        return responderName;
    }

    public void setResponderName(String responderName) {
        this.responderName = responderName;
    }

    public int getResponderAge() {
        return responderAge;
    }

    public void setResponderAge(int responderAge) {
        this.responderAge = responderAge;
    }
}

