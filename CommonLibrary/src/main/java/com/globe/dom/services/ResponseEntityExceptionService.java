package com.globe.dom.services;

import com.globe.dom.models.MetaData;
import com.globe.dom.models.ValidationError;
import com.globe.dom.utilities.ResponseUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResponseEntityExceptionService extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        //create Validation Error list to store Sub-Errors
        List<ValidationError> validationErrors = new ArrayList<>();

        //get field errors
        List<FieldError> fieldErrors = ex.getFieldErrors();
        //add field errors to list
        for(FieldError fieldError : fieldErrors){
            validationErrors.add(new ValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage(), fieldError.getRejectedValue()));
        }

        //get other errors
        List<ObjectError> otherErrors = ex.getGlobalErrors();
        //add other errors to list
        for(ObjectError otherError : otherErrors){
            validationErrors.add(new ValidationError(otherError.getObjectName(), null, otherError.getDefaultMessage(), null));
        }

        //build and return response entity
        return ResponseUtils.createResponseForFailure(new MetaData(HttpStatus.BAD_REQUEST,"The request failed its validation", ex, validationErrors));

    }

}
