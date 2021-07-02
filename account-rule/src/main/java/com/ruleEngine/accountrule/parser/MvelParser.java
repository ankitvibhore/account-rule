package com.ruleEngine.accountrule.parser;

import org.mvel2.MVEL;

import java.util.Map;

public class MvelParser {

    public Boolean parseExpression(String expression, Map<String, Object> inputObjects)
    {
        try{
            return MVEL.evalToBoolean(expression,inputObjects);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;

    }
}
