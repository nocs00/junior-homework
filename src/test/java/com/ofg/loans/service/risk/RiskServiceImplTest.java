package com.ofg.loans.service.risk;

import com.ofg.loans.model.Client;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.rules.RiskRule;
import com.ofg.loans.rules.impls.MaxAttemptsRiskRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Please add test cases for your risk service implementation.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class RiskServiceImplTest {
    @Autowired
    private RiskService service;
    @Autowired
    private Client client;

    @Test
    public void testApprove() {
        LoanApplication loanApplication = new LoanApplication("127.0.0.1", client, 90);
        Boolean approve = service.approve(loanApplication);
        assertTrue("Normal loan application should be approved", approve);
    }
}