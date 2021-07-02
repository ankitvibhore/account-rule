package com.ruleEngine.accountrule.service;

import com.ruleEngine.accountrule.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Engine {

    @Autowired
    private RuleService ruleService;

    public Object run(RuleEngine ruleEngine, Object inputData) {
        String ruleNamespace = ruleEngine.getRuleNamespace().toString();
        List<Rule> allRulesByNamespace = ruleService.getAllRuleByNamespace(ruleNamespace);
        Object result = ruleEngine.run(allRulesByNamespace, inputData);
        return result;
    }
}
