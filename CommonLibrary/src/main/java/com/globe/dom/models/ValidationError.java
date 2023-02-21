package com.globe.dom.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationError {

    private String object;
    private String field;
    private String message;
    private Object rejectedValue;

}
