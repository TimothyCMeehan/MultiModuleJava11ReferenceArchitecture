package com.globe.dom.utilities;

import com.globe.dom.models.MetaData;
import com.globe.dom.models.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    private ResponseUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> ResponseWrapper<T> wrapForSuccess(HttpStatus status, String message, T data){
        return new ResponseWrapper<>(status, new MetaData(status, message), data);
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> wrapInEntityForSuccess(HttpStatus status, String message, T data){
        return new ResponseEntity<>(wrapForSuccess(status, message, data), status);
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> createResponseForSuccess(T data){
        return wrapInEntityForSuccess(HttpStatus.OK, "Success", data);
    }

    public static ResponseWrapper<Object> wrapForFailure(MetaData metaData){
        return new ResponseWrapper<>(metaData.getStatus(), metaData, null);
    }

    public static ResponseEntity<Object> wrapInEntityForFailure(MetaData metaData){
        return new ResponseEntity<>(wrapForFailure(metaData), metaData.getStatus());
    }

    public static ResponseEntity<Object> createResponseForFailure(MetaData metaData){
        return wrapInEntityForFailure(metaData);
    }

}
