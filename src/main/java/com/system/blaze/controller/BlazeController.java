package com.system.blaze.controller;

import com.system.blaze.service.impl.BlazeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlazeController {

    @Autowired
    private BlazeServiceImpl blazeService;

    @GetMapping(path = "/transactionRiskDecision")
    public ResponseEntity<String> getRisk() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
