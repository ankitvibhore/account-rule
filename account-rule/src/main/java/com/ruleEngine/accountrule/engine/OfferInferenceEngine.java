package com.ruleEngine.accountrule.engine;

import com.ruleEngine.accountrule.enums.RuleNamespace;
import com.ruleEngine.accountrule.model.Account;
import com.ruleEngine.accountrule.model.Parametres;
import com.ruleEngine.accountrule.service.RuleEngine;

public class OfferInferenceEngine extends RuleEngine<Account, Parametres> {

    @Override
    protected Parametres initializeOutputResult() {
        return new Parametres();
    }

    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.Offer;
    }
}
