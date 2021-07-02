package com.ruleEngine.accountrule.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruleEngine.accountrule.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RuleReader {

    private final ObjectMapper objectMapper;

    public RuleReader(ObjectMapper objectMapper) {
        this.objectMapper = new ObjectMapper();
    }

    public List<Rule> getAccountRule() throws IOException {
   //     Rule rule = new Rule();
        List<Rule> ruleList = new ArrayList<>();
        TypeReference<List<Rule>> ruleType = new TypeReference<List<Rule>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("src/main/resources/account-rules.json");
        try{
             ruleList = objectMapper.readValue(inputStream,ruleType);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         //accountRules = objectMapper.readValue(new File("src/main/resources/account-rules.json"),Rule[].class);
       // return Arrays.asList(accountRules);

        return ruleList;
    }
}
