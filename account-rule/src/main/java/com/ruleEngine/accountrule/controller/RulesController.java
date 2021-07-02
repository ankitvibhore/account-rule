package com.ruleEngine.accountrule.controller;

import com.ruleEngine.accountrule.model.Account;
import com.ruleEngine.accountrule.model.RestResponse;
import com.ruleEngine.accountrule.model.RuleType;
import com.ruleEngine.accountrule.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class RulesController {

    @Autowired
    private RuleService ruleService;

    public ResponseEntity<?> runRuleEngine(@RequestBody Account account) throws IOException {
        RuleType restResponse = ruleService.runEngine(account);
        return ResponseEntity.ok(restResponse);
    }
}
