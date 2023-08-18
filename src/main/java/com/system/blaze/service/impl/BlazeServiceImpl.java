package com.system.blaze.service.impl;

import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlazeServiceImpl implements BlazeService {

    private MoneyLaunderingService moneyLaunderingService;
    private AmountService amountService;
    private BlackListCheckService blackListCheckService;

    private CountryService countryService;

    @Autowired
    public BlazeServiceImpl(MoneyLaunderingService moneyLaunderingService,
                            AmountService amountService,
                            BlackListCheckService blackListCheckService,
                            CountryService countryService) {
        this.moneyLaunderingService = moneyLaunderingService;
        this.amountService = amountService;
        this.blackListCheckService = blackListCheckService;
        this.countryService = countryService;
    }

    public void checkRisk(RiskRequest riskRequest) {
        blackListCheckService.checkBlackedList(riskRequest);
        moneyLaunderingService.check(riskRequest);
        amountService.checkAmount(riskRequest.getPaymentDetails());
        countryService.check(riskRequest);
    }
}
