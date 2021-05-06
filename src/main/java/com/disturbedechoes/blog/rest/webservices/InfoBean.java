package com.disturbedechoes.blog.rest.webservices;

public class InfoBean {

    private String message;

    public InfoBean(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
