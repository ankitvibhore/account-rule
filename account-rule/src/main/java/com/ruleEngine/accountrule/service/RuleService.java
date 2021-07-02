package com.ruleEngine.accountrule.service;

import com.ruleEngine.accountrule.engine.OfferInferenceEngine;
import com.ruleEngine.accountrule.engine.TreatmentInferenceEngine;
import com.ruleEngine.accountrule.enums.OfferTag;
import com.ruleEngine.accountrule.enums.RuleNamespace;
import com.ruleEngine.accountrule.enums.TreatementTools;
import com.ruleEngine.accountrule.model.Account;
import com.ruleEngine.accountrule.model.RestResponse;
import com.ruleEngine.accountrule.model.Rule;
import com.ruleEngine.accountrule.model.RuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class RuleService {

    @Autowired
    private RestResponse restResponse;

    @Autowired
    private OfferTag offerTag;

    @Autowired
    private TreatementTools treatementTools;

    @Autowired
    private RuleReader ruleReader;

    @Autowired
    private Engine engine;

    @Autowired
    private OfferInferenceEngine offerInferenceEngine;

    @Autowired
    private TreatmentInferenceEngine treatmentInferenceEngine;

    public RuleType runEngine(Account account) throws IOException {
        RuleType ruleType = new RuleType();

        if (!offerTag.equals(account.getOfferTag()) || !(treatementTools.equals(account.getTreatmentTool())))
        {
            throw new IllegalArgumentException("OfferTag and Treatment tool not available");
        }
 //       List<Rule> ruleList = ruleReader.getAccountRule();
        if (Objects.nonNull(engine.run(offerInferenceEngine,account)) && Objects.nonNull(engine.run(treatmentInferenceEngine,account)))
        {
            ruleType.setOffer(true);
            ruleType.setTreatment(true);
        }
        else
            if ( !Objects.nonNull(engine.run(offerInferenceEngine,account)) && Objects.nonNull(engine.run(treatmentInferenceEngine,account)))
            {
                ruleType.setOffer(false);
                ruleType.setTreatment(true);
            }
            else
                if(Objects.nonNull(engine.run(offerInferenceEngine,account)) && !Objects.nonNull(engine.run(treatmentInferenceEngine,account)))
                {
                    ruleType.setOffer(true);
                    ruleType.setTreatment(false);
                }
                else {
                    ruleType.setOffer(false);
                    ruleType.setTreatment(false);
                }
        return ruleType;
    }

//    private Rule mapRuleFromJson(RuleReader ruleReader)
//    {
//        return ;

//    }

    public List<Rule> getAllRuleByNamespace(String ruleNamespace) {
        try {
            List<Rule> ruleList = ruleReader.getAccountRule();
            for (Rule rule : ruleList)
            {
                if (rule.getRuleNamespace().equals(ruleNamespace))
                {
                    ruleList.add(rule);
                }
                return ruleList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
