package com.system.blaze.service.impl;

import com.system.blaze.customException.SanctionedCountryException;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.CountryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    @Value("${blaze.sanctionedCountries}")
    private Set<String> sanctionedCountries;

    public void check(RiskRequest riskRequest) {
        checkSendingCountry(riskRequest.getCustomer().getAddress().getCountry());
        checkReceivingCountry(riskRequest.getReceiver().getAddress().getCountry());
    }

    private void checkSendingCountry(String country) {
        checkSanctionedCountry("from", country);
    }

    private void checkReceivingCountry(String country) {
        checkSanctionedCountry("to", country);
    }

    private void checkSanctionedCountry(String msg, String country) {
        sanctionedCountries.forEach(sanctionedCountry -> {
            if (sanctionedCountry.equalsIgnoreCase(country)) {
                throw new SanctionedCountryException("Cannot send money " + msg + " " + country + " due to sanctions");
            }
        });
    }
}
