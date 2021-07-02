package com.ruleEngine.accountrule.model;

public class Parametres {

    private Boolean isOffer;
    private Boolean isTreatment;
    private String strategyId;

    public Parametres(Boolean isOffer, Boolean isTreatment, String strategyId) {
        this.isOffer = isOffer;
        this.isTreatment = isTreatment;
        this.strategyId = strategyId;
    }

    public Parametres() {
    }

    public Parametres(Boolean isOffer, String strategyId) {
        this.isOffer = isOffer;
        this.strategyId = strategyId;
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

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }
}
