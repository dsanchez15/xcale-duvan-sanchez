package com.xcale.test.demo.dominio;

import java.util.List;

public class MessageDto {
    private String numberSource;
    private String message;
    private boolean fromGroupChat;
    private List<String> numberTargets;

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

    public boolean fromGroupChat() {
        return fromGroupChat;
    }

    public void setFromGroupChat(boolean fromGroupChat) {
        this.fromGroupChat = fromGroupChat;
    }

    public List<String> getNumberTargets() {
        return numberTargets;
    }

    public void setNumberTargets(List<String> numberTargets) {
        this.numberTargets = numberTargets;
    }
}
