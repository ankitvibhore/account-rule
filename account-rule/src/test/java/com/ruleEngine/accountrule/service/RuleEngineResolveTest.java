package com.ruleEngine.accountrule.service;

import com.ruleEngine.accountrule.enums.RuleNamespace;
import com.ruleEngine.accountrule.model.Rule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleEngineResolveTest {

    @Test
    void compareToShouldPreferHigherPriorityThenRuleId() {
        Rule highPriorityRule = rule("2", 9);
        Rule lowPriorityRule = rule("1", 2);
        Rule samePriorityRuleWithHigherId = rule("20", 9);

        assertEquals(-1, highPriorityRule.compareTo(lowPriorityRule));
        assertEquals(-1, highPriorityRule.compareTo(samePriorityRuleWithHigherId));
    }


    @Test
    void equalsAndHashCodeShouldBeConsistentWithComparableIdentity() {
        Rule left = rule("1", 5);
        Rule right = rule("1", 5);
        Rule differentPriority = rule("1", 6);

        assertEquals(left, right);
        assertEquals(left.hashCode(), right.hashCode());
        assertNotEquals(left, differentPriority);
        assertTrue(left.compareTo(right) == 0);
    }

    @Test
    void resolveShouldReturnRuleWithBestPriorityUsingComparable() {
        TestableRuleEngine ruleEngine = new TestableRuleEngine();
        List<Rule> conflictSet = Arrays.asList(
                rule("3", 3),
                rule("1", 5),
                rule("2", 5)
        );

        Rule resolvedRule = ruleEngine.resolveRule(conflictSet);

        assertEquals("1", resolvedRule.getRuleId());
        assertEquals(5, resolvedRule.getPriority());
    }

    @Test
    void resolveShouldReturnNullWhenConflictSetIsEmpty() {
        TestableRuleEngine ruleEngine = new TestableRuleEngine();

        Rule resolvedRule = ruleEngine.resolveRule(Collections.emptyList());

        assertNull(resolvedRule);
    }

    private Rule rule(String id, int priority) {
        Rule rule = new Rule();
        rule.setRuleId(id);
        rule.setPriority(priority);
        return rule;
    }

    private static class TestableRuleEngine extends RuleEngine<Object, Object> {

        Rule resolveRule(List<Rule> rules) {
            return resolve(rules);
        }

        @Override
        protected Object initializeOutputResult() {
            return new Object();
        }

        @Override
        protected RuleNamespace getRuleNamespace() {
            return RuleNamespace.Offer;
        }
    }
}
