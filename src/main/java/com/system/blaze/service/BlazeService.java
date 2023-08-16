package com.system.blaze.service;

import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Receiver;

public interface BlazeService {
    public String checkSender(Customer customer);

    public String checkReceiver(Receiver receiver);
}
