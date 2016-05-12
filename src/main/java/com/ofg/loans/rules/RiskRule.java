package com.ofg.loans.rules;

import com.ofg.loans.model.LoanApplication;

import java.util.function.Predicate;

/**
 * Created by pdudenkov on 12.05.2016.
 */
@FunctionalInterface
public interface RiskRule {
    boolean check(LoanApplication loanApplication);

    default RiskRule and(RiskRule another) {
        return t -> check(t) && another.check(t);
    }

    default RiskRule or(RiskRule another) {
        return t -> check(t) || another.check(t);
    }
}
