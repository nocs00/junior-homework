package com.ofg.loans.service.risk;

import com.ofg.loans.model.Client;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.utils.IPHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Please add test cases for your risk service implementation.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class RiskServiceImplTest {
    @Autowired
    private RiskService service;
    @Autowired
    private Client client;
    @Autowired
    List<LoanApplication> testApplications;

    @Resource(name = "mockIpMap")
    Map<String, Integer> ipMap;

    @Before
    public void init() {
        IPHistory.init(ipMap);
    }

    @Test
    public void testApprove() {
        List<Boolean> testApprovals = new ArrayList<>(testApplications.size());
        testApplications.forEach(L -> testApprovals.add(service.approve(L)));

        assertTrue("Normal loan application should be approved", testApprovals.get(0));
        assertTrue("Normal loan application should be approved", testApprovals.get(1));
        assertFalse("Risky loan application should not be approved", testApprovals.get(2));
        assertFalse("Risky loan application should not be approved", testApprovals.get(3));
        assertFalse("Risky loan application should not be approved", testApprovals.get(4));
    }
}