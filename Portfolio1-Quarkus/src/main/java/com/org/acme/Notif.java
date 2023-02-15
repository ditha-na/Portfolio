package com.org.acme;


import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

public class Notif {

    Notif (String message) {
        this.success = true;
        this.message = message;
    }

    Notif (String message, boolean success) {
        this.success = success;
        this.message = message;
    }

    /* New Constructor */
    Notif (String message, Object data) {
        this.success = true;
        this.message = message;
        this.data = data;
    }

    Notif (Set<? extends ConstraintViolation<?>> violations) {
        this.success = false;
        this.message = violations.stream().map(cv -> cv.getMessage()).collect(Collectors.joining(", "));
    }

    private boolean success;
    private String message;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    /* New Method */
    public Object getData() {
        return data;
    }

    private Long status;

    public Notif(boolean success, Long status, String message, Object data) {
        super();
        this.success = true;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
