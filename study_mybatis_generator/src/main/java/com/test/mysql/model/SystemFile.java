package com.test.mysql.model;

import java.util.Date;

public class SystemFile {
    private Integer contractStepId;

    private Integer adminUserId;

    private Boolean step1Confirm;

    private Boolean step2Confirm;

    private Boolean step3Confirm;

    private Boolean step4Confirm;

    private Boolean step5Confirm;

    private Date ctime;

    public Integer getContractStepId() {
        return contractStepId;
    }

    public void setContractStepId(Integer contractStepId) {
        this.contractStepId = contractStepId;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Boolean getStep1Confirm() {
        return step1Confirm;
    }

    public void setStep1Confirm(Boolean step1Confirm) {
        this.step1Confirm = step1Confirm;
    }

    public Boolean getStep2Confirm() {
        return step2Confirm;
    }

    public void setStep2Confirm(Boolean step2Confirm) {
        this.step2Confirm = step2Confirm;
    }

    public Boolean getStep3Confirm() {
        return step3Confirm;
    }

    public void setStep3Confirm(Boolean step3Confirm) {
        this.step3Confirm = step3Confirm;
    }

    public Boolean getStep4Confirm() {
        return step4Confirm;
    }

    public void setStep4Confirm(Boolean step4Confirm) {
        this.step4Confirm = step4Confirm;
    }

    public Boolean getStep5Confirm() {
        return step5Confirm;
    }

    public void setStep5Confirm(Boolean step5Confirm) {
        this.step5Confirm = step5Confirm;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}