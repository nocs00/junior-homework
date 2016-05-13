package com.ofg.loans.controller;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.service.risk.RiskService;
import com.ofg.loans.utils.IPHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * Created by pdudenkov on 13.05.2016.
 */

@Controller
public class RiskServiceController {
    @Autowired
    private RiskService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loanJSP", new LoanApplication());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/approve-loan")
    public ModelAndView approveLoan(
            @ModelAttribute("loanJSP") LoanApplication loanApplication,
            HttpServletRequest request
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("secondPage");

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        loanApplication.setApplicationTS(LocalDateTime.now());
        loanApplication.setIpAddress(ipAddress);
        IPHistory.addAttempt(ipAddress);


        modelAndView.addObject("loanJSP", loanApplication);
        modelAndView.addObject("isLoanApproved", service.approve(loanApplication));
        modelAndView.addObject("ipAttempts", IPHistory.checkIp(ipAddress));

        return modelAndView;
    }
}
