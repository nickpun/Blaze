package com.system.blaze.exceptionHandler;

import com.system.blaze.customException.*;
import com.system.blaze.customRespond.CustomErrorRespond;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ConfigurationProperties("")
@Data
@Slf4j
public class RestExceptionHandler {

//    @Value("#{${errorcode}}")
    private HashMap<String, String> error_map;


    @PostConstruct
    void func() {
        error_map.forEach((k, y) -> log.debug("key " + k + " val " + y) );
        log.debug("" + error_map.size());
    }



    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(BlacklistException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);

    }


    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(MoneyLaunderingException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(AmountException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(SanctionedCountryException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorRespond> respondResponseEntity(InvalidCountryException e) {
        CustomErrorRespond customErrorRespond =
                CustomErrorRespond.builder().errorCode(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }
}
