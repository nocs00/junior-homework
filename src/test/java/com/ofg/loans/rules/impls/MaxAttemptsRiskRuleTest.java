package com.ofg.loans.rules.impls;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.utils.IPHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class MaxAttemptsRiskRuleTest {
    @Autowired
    LoanApplication goodLoanApplication;
    @Autowired
    LoanApplication badLoanApplication;
    @Autowired
    MaxAttemptsRiskRule rule;

    @Resource(name = "mockIpMap")
    Map<String, Integer> ipMap;

    @Before
    public void init() {
        IPHistory.init(ipMap);
    }

    @Test
    public void testCheck() throws Exception {
        assertTrue("Normal loan application should be approved", rule.check(goodLoanApplication));
        assertFalse("Risky loan application should not be approved", rule.check(badLoanApplication));
    }
}