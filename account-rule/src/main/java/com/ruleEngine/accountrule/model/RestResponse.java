package com.ruleEngine.accountrule.model;

public class RestResponse {

    private String emailCode;
    private String letterCode;

    public RestResponse(String emailCode, String letterCode) {
        this.emailCode = emailCode;
        this.letterCode = letterCode;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }
}
