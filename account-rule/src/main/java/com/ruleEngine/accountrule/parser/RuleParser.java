package com.ruleEngine.accountrule.parser;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class RuleParser<INPUT_DATA,OUTPUT_RESULT> {

    private final String INPUT_KEYWORD = "input";
    private final String OUTPUT_KEYWORD = "output";

    @Autowired
    private MvelParser mvelParser;

    public boolean parseCondition(String expression, INPUT_DATA inputData) {
        Map<String, Object> input = new HashMap<>();
        input.put(INPUT_KEYWORD, inputData);
        boolean match = mvelParser.parseExpression(expression, input);
        return match;
    }


    public OUTPUT_RESULT parseAction(String expression, INPUT_DATA inputData, OUTPUT_RESULT outputResult) {
        Map<String, Object> input = new HashMap<>();
        input.put(INPUT_KEYWORD, inputData);
        input.put(OUTPUT_KEYWORD, outputResult);
        mvelParser.parseExpression(expression, input);
        return outputResult;
    }


}
