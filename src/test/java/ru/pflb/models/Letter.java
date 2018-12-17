package ru.pflb.models;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    private List<String> recipientList = new ArrayList<>();
    private String topic;
    private String body;

    public List<String> getRecipientList(){
        return recipientList;
    }

    public Letter addRecipient(String recipient){
        this.recipientList.add(recipient);
        return this;
    }

    public String getTopic(){
        return topic;
    }

    public Letter setTopic(String topic){
        this.topic = topic;
        return this;
    }

    public String getBody(){
        return body;
    }

    public Letter setBody(String body){
        this.body = body;
        return this;
    }

}