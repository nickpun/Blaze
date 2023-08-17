package com.system.blaze.service.impl;

import com.system.blaze.customException.BlacklistException;
import com.system.blaze.customException.MoneyLaunderingException;
import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.BlazeService;
import com.system.blaze.service.MoneyLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BlazeServiceImpl implements BlazeService {

    @Value("${blaze.blackListedpeople}")
    private List<String> blackListedNames;

    private MoneyLaunderingService moneyLaunderingService;

    @Autowired
    public BlazeServiceImpl(MoneyLaunderingService moneyLaunderingService) {
        this.moneyLaunderingService = moneyLaunderingService;
    }

    public String checkSender(Customer customer) {
        return "Sender " + checkBlackListedLastName(customer.getName());
    }

    public String checkReceiver(Receiver receiver) {
        return "Receiver " + checkBlackListedLastName(receiver.getName());
    }

    public String checkBlackedList(RiskRequest riskRequest) {
        checkSender(riskRequest.getCustomer());
        checkReceiver(riskRequest.getReceiver());
        return "";
    }

    public String checkAmount() {
        return "";
    }


    private String checkBlackListedLastName(Name name) {
        String lastName = name.getLastName();
        for (String n : blackListedNames) {
            if (lastName.equalsIgnoreCase(n)) {
                throw new BlacklistException(name.getLastName() + " has been blacklisted");
            }
        }
        return "last name is okay";
    }

    public String checkRisk(RiskRequest riskRequest) {
        checkBlackedList(riskRequest);
        moneyLaunderingService.check(riskRequest);
        return "";
    }
}
