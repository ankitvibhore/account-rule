package com.ruleEngine.accountrule.model;

import java.util.Date;


public class Account {

    Integer placementDate;
    String offerTag;
    String treatmentTool;

    public Account(Integer placementDate, String offerTag, String treatmentTool) {
        this.placementDate = placementDate;
        this.offerTag = offerTag;
        this.treatmentTool = treatmentTool;
    }

    public Integer getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Integer placementDate) {
        this.placementDate = placementDate;
    }

    public String getOfferTag() {
        return offerTag;
    }

    public void setOfferTag(String offerTag) {
        this.offerTag = offerTag;
    }

    public String getTreatmentTool() {
        return treatmentTool;
    }

    public void setTreatmentTool(String treatmentTool) {
        this.treatmentTool = treatmentTool;
    }


}
