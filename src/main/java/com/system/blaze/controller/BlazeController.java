package com.system.blaze.controller;

import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.impl.BlazeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlazeController {

    @Autowired
    private BlazeServiceImpl blazeService;

    @PostMapping(path = "/transactionRiskDecision")
    public ResponseEntity<?> getRisk(@RequestBody RiskRequest riskRequest) {
        String senderNameCheck = blazeService.checkSender(riskRequest.getCustomer());
        String receiverNameCheck = blazeService.checkReceiver(riskRequest.getReceiver());
        return new ResponseEntity<>(senderNameCheck + "\n" + receiverNameCheck, HttpStatus.OK);
    }

    @PostMapping( "/sendMoneyValidation")
    public ResponseEntity<?> getRisk2(@RequestBody RiskRequest riskRequest) {
        System.out.println(riskRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
