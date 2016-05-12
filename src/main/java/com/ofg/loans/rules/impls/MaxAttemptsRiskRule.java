package com.ofg.loans.rules.impls;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.rules.RiskRule;

import java.util.HashMap;
import java.util.Map;

import static com.ofg.loans.service.risk.RiskService.*;

/**
 * Created by pdudenkov on 12.05.2016.
 */
public class MaxAttemptsRiskRule implements RiskRule {
    private static Map<String, Integer> ipMap = new HashMap<>();

    @Override
    public boolean check(LoanApplication loanApplication) {
        Integer attempts = ipMap.get(loanApplication.getIpAddress());
        if (attempts != null)
            return attempts < MAXIMUM_ATTEMPTS_PER_IP_ADDRESS;

        return true;
    }


    /* This data comes from Servlet
    *
    *String ipAddress = servletRequest.getHeader("X-FORWARDED-FOR");
    *if (ipAddress == null) {
	*   ipAddress = request.getRemoteAddr();
    *}
    *
     */
    public static void addIpAttempt(String ip) {
        if (ipMap.containsKey(ip))
            ipMap.put(ip, 1);
        else
            ipMap.put(ip, ipMap.get(ip)+1);
    }
}
