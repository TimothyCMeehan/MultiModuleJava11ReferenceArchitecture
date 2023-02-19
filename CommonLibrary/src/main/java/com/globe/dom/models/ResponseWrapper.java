package com.globe.dom.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public class ResponseWrapper <E>{

    private HttpStatus status;
    private String message;
    private E data;


}
