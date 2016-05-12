package com.ofg.loans.model;

import com.ofg.loans.rules.RiskRule;
import com.ofg.loans.service.risk.RiskService;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Loan application entity.
 */
public class LoanApplication {
    private String ipAddress;
    private LocalDateTime applicationTS;
    private Client client;
    private int amount;

    public LoanApplication(String ipAddress, Client client, int amount) {
        this.client = client;
        this.amount = amount;
        applicationTS = LocalDateTime.now();

        if (this.amount > RiskService.MAXIMUM_LOAN_AMOUNT)
            this.amount = RiskService.MAXIMUM_LOAN_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getApplicationTS() {
        return applicationTS;
    }

    public Client getClient() {
        return client;
    }
}
