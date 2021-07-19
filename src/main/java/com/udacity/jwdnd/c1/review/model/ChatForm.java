package com.udacity.jwdnd.c1.review.model;

public class ChatForm {
    private String username;
    private String message;
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void emptyOut(){this.username=""; this.message=""; this.type="";}
}
