package br.com.vitor.rest_with_spring_boot_and_java_vitor.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{
    private static final long serialVersionUID = 1l;

   
    private Date timestamp;

    private String message;
    private String details;
    
    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
       
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    
}
