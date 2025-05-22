package br.com.vitor.rest_with_spring_boot_and_java_vitor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String ex){
        super(ex);
    }

    private static final long serialVersionUID = 1L;
}
