package com.ruleEngine.accountrule.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruleEngine.accountrule.enums.RuleNamespace;

public class Rule {

    @JsonProperty("rule_id")
    private  String ruleId;
    @JsonProperty("condition")
    private  String condition;
    @JsonProperty("action")
    private  String action;
    @JsonProperty("priority")
    private  int priority;
    @JsonProperty("rule_namespace")
    private RuleNamespace ruleNamespace;
    @JsonProperty("description")
    private  String description;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }



    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public RuleNamespace getRuleNamespace() {
        return ruleNamespace;
    }

    public void setRuleNamespace(RuleNamespace ruleNamespace) {
        this.ruleNamespace = ruleNamespace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleId='" + ruleId + '\'' +
                ", condition='" + condition + '\'' +
                ", action='" + action + '\'' +
                ", priority=" + priority +
                ", ruleNamespace='" + ruleNamespace + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
