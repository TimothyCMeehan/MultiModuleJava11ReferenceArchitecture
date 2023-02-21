package com.globe.dom.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@ToString
public class MetaData {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ValidationError> subErrors;

    private MetaData(){
        this.timestamp = LocalDateTime.now();
    }

    public MetaData(HttpStatus status){
        this();
        this.status = status;
    }
    //Used for success cases
    public MetaData(HttpStatus status, String message){
        this(status);
        this.message = message;
    }

    public MetaData(HttpStatus status, String message, Throwable exception){
        this(status, message);
        this.debugMessage = exception.getLocalizedMessage();
    }

    public MetaData(HttpStatus status, String message, Throwable exception, List<ValidationError> subErrors){
        this(status, message, exception);
        this.debugMessage = exception.getLocalizedMessage();
        this.subErrors = subErrors;
    }

    public MetaData(HttpStatus status, Throwable exception){
        this(status, "Unexpected Error", exception);
    }




}
