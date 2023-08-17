package com.system.blaze.service.impl;

import com.system.blaze.customException.BlacklistException;
import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.AmountService;
import com.system.blaze.service.BlackListCheckService;
import com.system.blaze.service.BlazeService;
import com.system.blaze.service.MoneyLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlazeServiceImpl implements BlazeService {

    private MoneyLaunderingService moneyLaunderingService;
    private AmountService amountService;
    private BlackListCheckService blackListCheckService;

    @Autowired
    public BlazeServiceImpl(MoneyLaunderingService moneyLaunderingService, AmountService amountService, BlackListCheckService blackListCheckService) {
        this.moneyLaunderingService = moneyLaunderingService;
        this.amountService = amountService;
        this.blackListCheckService = blackListCheckService;
    }

    public void checkRisk(RiskRequest riskRequest) {
        blackListCheckService.checkBlackedList(riskRequest);
        moneyLaunderingService.check(riskRequest);
        amountService.checkAmount(riskRequest.getPaymentDetails());
    }
}
