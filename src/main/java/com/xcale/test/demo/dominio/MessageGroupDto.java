package com.xcale.test.demo.dominio;

import java.util.List;

public class MessageGroupDto {
    private String numberSource;
    private String message;
    private List<String> numberTargets;

    public MessageGroupDto(MessageDto message) {
        this.numberSource = message.getNumberSource();
        this.message = message.getMessage();
        this.numberTargets = message.getNumberTargets();
    }

    public String getNumberSource() {
        return numberSource;
    }

    public void setNumberSource(String numberSource) {
        this.numberSource = numberSource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getNumberTargets() {
        return numberTargets;
    }

    public void setNumberTargets(List<String> numberTargets) {
        this.numberTargets = numberTargets;
    }
}
