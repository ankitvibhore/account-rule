package com.ruleEngine.accountrule.model;

public class RuleType {

    Boolean isOffer;
    Boolean isTreatment;

    public Boolean getOffer() {
        return isOffer;
    }

    public void setOffer(Boolean offer) {
        isOffer = offer;
    }

    public Boolean getTreatment() {
        return isTreatment;
    }

    public void setTreatment(Boolean treatment) {
        isTreatment = treatment;
    }
}
