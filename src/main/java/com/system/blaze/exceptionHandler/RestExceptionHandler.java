package com.system.blaze.exceptionHandler;

import com.system.blaze.customException.BlacklistException;
import com.system.blaze.customRespond.CustomeErrorRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomeErrorRespond> respondResponseEntity(BlacklistException e) {

        CustomeErrorRespond customeErrorRespond =
                CustomeErrorRespond.builder().errorCode(1010).message(e.getMessage()).build();
        return new ResponseEntity<>(customeErrorRespond, HttpStatus.OK);

    }



}
