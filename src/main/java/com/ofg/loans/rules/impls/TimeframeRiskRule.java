package com.ofg.loans.rules.impls;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.rules.RiskRule;
import com.ofg.loans.service.risk.RiskService;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ofg.loans.service.risk.RiskService.*;

/**
 * Created by pdudenkov on 12.05.2016.
 */
public class TimeframeRiskRule implements RiskRule {
    @Value("${risky.hour.from}")
    private String fromHour;
    @Value("${risky.hour.to}")
    private String toHour;

    @Override
    public boolean check(LoanApplication loanApplication) {
        LocalTime loanTime = loanApplication.getApplicationTS().toLocalTime();
        boolean afterStart = loanTime.isAfter(LocalTime.of(Integer.parseInt(fromHour), 0));
        boolean beforeEnd = loanTime.isBefore(LocalTime.of(Integer.parseInt(toHour), 0));
        boolean inNormalTimeframe = !(afterStart && beforeEnd);
        boolean riskyAmount = loanApplication.getAmount() == RiskService.MAXIMUM_LOAN_AMOUNT;

        return inNormalTimeframe && !riskyAmount;
    }
}
