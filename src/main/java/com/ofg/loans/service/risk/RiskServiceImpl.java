package com.ofg.loans.service.risk;


import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.rules.RiskRule;
import com.ofg.loans.rules.impls.MaxAttemptsRiskRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pdudenkov on 12.05.2016.
 * List needed here to inject from context.xml
 */
@Service
public class RiskServiceImpl implements RiskService {
    private List<RiskRule> riskRules;

    @Autowired
    public void setRiskRules(List<RiskRule> riskRules) {
        this.riskRules = riskRules;
    }

    @Override
    public Boolean approve(LoanApplication loanApplication) {
        for (RiskRule rule : riskRules) {
            if (!rule.check(loanApplication))
                return false;
        }

        return true;
    }

    public void addRiskRule(RiskRule riskRule) {
        riskRules.add(riskRule);
    }
}
