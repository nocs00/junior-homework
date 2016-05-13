package com.ofg.loans.rules;

import com.ofg.loans.model.LoanApplication;

import java.util.function.Predicate;

/**
 * Created by pdudenkov on 12.05.2016.
 *
 * Two use-cases:
 * first - just implement this interface as in package com.ofg.loans.rules.impls;
 * second - make linkage of predicates right in client code:
 *      RiskRule maxAmountRule = L -> L.getAmount() < 100;
 *      RiskRule afterSixxAMRule = L -> L.getApplicationTS().toLocalTime().isAfter(LocalTime.of(6, 0));
 *      RiskRule linkThem = maxAmountRule.and(afterSixxAMRule);
 *      RiskRule reversedRule = linkThem.negate();
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

    default RiskRule negate() {
        return t -> !check(t);
    }
}
