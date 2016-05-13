package com.ofg.loans.model;

import com.ofg.loans.service.risk.RiskService;

import java.time.LocalDateTime;


/**
 * Loan application entity.
 */
public class LoanApplication {
    private String ipAddress;
    private LocalDateTime applicationTS;
    private Client client;
    private int amount;
    private int termDays;

    public LoanApplication() {
        client = new Client();
        applicationTS = LocalDateTime.now();
    }

    public LoanApplication(String ipAddress, Client client, int amount, int termDays) {
        this.ipAddress = ipAddress;
        this.client = client;
        this.amount = amount;
        this.termDays = termDays;
        applicationTS = LocalDateTime.now();

        if (this.amount > RiskService.MAXIMUM_LOAN_AMOUNT || this.amount < 1)
            this.amount = RiskService.MAXIMUM_LOAN_AMOUNT;
        if (this.termDays < 1)
            this.termDays = 7;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTermDays(int termDays) {
        this.termDays = termDays;
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

    public void setApplicationTS(LocalDateTime applicationTS) {
        this.applicationTS = applicationTS;
    }

    public int getTermDays() {
        return termDays;
    }
}
