package com.test.mysql.model;

import java.util.Date;

public class ttt {
    private Integer messageMerchantInfoId;

    private Integer adminUserId;

    private String adminUserName;

    private String content;

    private Date ctime;

    private Boolean isauto;

    public Integer getMessageMerchantInfoId() {
        return messageMerchantInfoId;
    }

    public void setMessageMerchantInfoId(Integer messageMerchantInfoId) {
        this.messageMerchantInfoId = messageMerchantInfoId;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName == null ? null : adminUserName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Boolean getIsauto() {
        return isauto;
    }

    public void setIsauto(Boolean isauto) {
        this.isauto = isauto;
    }
}