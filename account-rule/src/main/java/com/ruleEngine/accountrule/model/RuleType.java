package com.ruleEngine.accountrule.model;

public class RuleType {

    private Boolean isOffer;
    private Boolean isTreatment;

    public RuleType() {
    }

    public RuleType(Boolean isOffer, Boolean isTreatment) {
        this.isOffer = isOffer;
        this.isTreatment = isTreatment;
    }

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
