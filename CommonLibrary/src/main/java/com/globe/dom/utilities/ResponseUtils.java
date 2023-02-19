package com.globe.dom.utilities;

import com.globe.dom.models.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    private ResponseUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> ResponseWrapper<T> wrap(HttpStatus status, String message, T data){
        return new ResponseWrapper<>(status, message, data);
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> wrapInEntity(HttpStatus status, String message, T data){
        return new ResponseEntity<>(wrap(status, message, data), status);
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> createResponseForSuccess(T data){
        return wrapInEntity(HttpStatus.OK, "Success", data);
    }

}
