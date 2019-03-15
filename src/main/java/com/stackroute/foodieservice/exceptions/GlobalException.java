package com.stackroute.foodieservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e) {
        return new ResponseEntity<String>("erorr exception occured  " + e.getMessage(), HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

    }
    @ExceptionHandler( value=RestaurantAlreadyExists.class)
    public ResponseEntity<String> exception(RestaurantAlreadyExists e){
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        e.printStackTrace();
        return responseEntity;
    }
    @ExceptionHandler(value=RestaurantNotFound.class)
    public ResponseEntity<String> exceptionNotFound(RestaurantNotFound e){
        ResponseEntity responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        e.printStackTrace();
        return  responseEntity;
    }

}
