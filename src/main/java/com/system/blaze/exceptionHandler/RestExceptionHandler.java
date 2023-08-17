package com.system.blaze.exceptionHandler;

import com.system.blaze.customException.AmountException;
import com.system.blaze.customException.BlacklistException;
import com.system.blaze.customException.MoneyLaunderingException;
import com.system.blaze.customRespond.CustomErrorRespond;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class RestExceptionHandler {

    @Value("#{${errorcode}}")
    private HashMap<String, String> map;



    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(BlacklistException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);

    }


    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(MoneyLaunderingException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(AmountException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }



}
