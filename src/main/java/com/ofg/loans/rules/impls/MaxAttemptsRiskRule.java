package com.ofg.loans.rules.impls;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.rules.RiskRule;
import com.ofg.loans.utils.IPHistory;

import static com.ofg.loans.service.risk.RiskService.MAXIMUM_ATTEMPTS_PER_IP_ADDRESS;

/**
 * Created by pdudenkov on 12.05.2016.
 */
public class MaxAttemptsRiskRule implements RiskRule {
    @Override
    public boolean check(LoanApplication loanApplication) {
        String ipAddress = loanApplication.getIpAddress();
        Integer attempts = IPHistory.checkIp(ipAddress);
        return attempts < MAXIMUM_ATTEMPTS_PER_IP_ADDRESS;
    }
}
