package com.example.sample.persistance.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericSuccess<T> extends ResponseEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;


    public GenericSuccess(T body, HttpStatus status) {
        super(body, status);
        this.timestamp=LocalDateTime.now();
    }

    public GenericSuccess(HttpStatus status) {
        super(status);
        this.timestamp=LocalDateTime.now();
    }

    public GenericSuccess(T body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }
}
