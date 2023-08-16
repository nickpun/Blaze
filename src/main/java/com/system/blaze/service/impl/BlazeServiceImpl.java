package com.system.blaze.service.impl;

import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.service.BlazeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlazeServiceImpl implements BlazeService {

    private List<String> names = new ArrayList<>();

    public String checkSender(Customer customer) {
        return "Sender " + checkLastName(customer.getName());
    }

    public String checkReceiver(Receiver receiver) {
        return "Receiver " + checkLastName(receiver.getName());
    }

    private String checkLastName(Name name) {
        names.add("alex");
        names.add("bruce");
        names.add("charlie");

        String lastName = name.getLastName();
        for (String n : names) {
            if (lastName.toLowerCase().equals(n)) {
                return "last name is blacklisted";
            }
        }
        return "last name is okay";
    }
}
