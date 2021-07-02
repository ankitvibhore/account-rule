package com.ruleEngine.accountrule.service;

import com.ruleEngine.accountrule.enums.RuleNamespace;
import com.ruleEngine.accountrule.model.Rule;
import com.ruleEngine.accountrule.parser.RuleParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class RuleEngine<INPUT_DATA, OUTPUT_RESULT> {

    @Autowired
    private RuleParser<INPUT_DATA, OUTPUT_RESULT> ruleParser;

    public OUTPUT_RESULT run (List<Rule> listOfRules, INPUT_DATA inputData){
        if (null == listOfRules || listOfRules.isEmpty()){
            return null;
        }

        List<Rule> conflictSet = match(listOfRules, inputData);

        Rule resolvedRule = resolve(conflictSet);
        if (null == resolvedRule){
            return null;
        }

        //STEP 3 (EXECUTE) : Run the action of the selected rule on given data and return the output.
        OUTPUT_RESULT outputResult = executeRule(resolvedRule, inputData);

        return outputResult;
    }

    protected List<Rule> match(List<Rule> listOfRules, INPUT_DATA inputData){
        return listOfRules.stream()
                .filter(
                        rule -> {
                            String condition = rule.getCondition();
                            return ruleParser.parseCondition(condition, inputData);
                        }
                )
                .collect(Collectors.toList());
    }

    protected Rule resolve(List<Rule> conflictSet){
        Optional<Rule> rule = conflictSet.stream()
                .findFirst();
        if (rule.isPresent()){
            return rule.get();
        }
        return null;
    }

    protected OUTPUT_RESULT executeRule(Rule rule, INPUT_DATA inputData){
        OUTPUT_RESULT outputResult = initializeOutputResult();
        return ruleParser.parseAction(rule.getAction(), inputData, outputResult);
    }

    protected abstract OUTPUT_RESULT initializeOutputResult();
    protected abstract RuleNamespace getRuleNamespace();
}
