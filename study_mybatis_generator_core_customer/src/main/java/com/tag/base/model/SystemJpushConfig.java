package com.tag.base.model;

import com.tag.framework.model.AbstractObject;
import java.util.Date;

public class SystemJpushConfig extends AbstractObject {
    /**
     * system_jpush_config.system_jpush_config_id : 主键
     */
    private Integer systemJpushConfigId;

    /**
     * system_jpush_config.config_app : 配置APP
     */
    private String configApp;

    /**
     * system_jpush_config.config_name : 配置名称
     */
    private String configName;

    /**
     * system_jpush_config.is_on_off : 消息是否打开：on可以接收消息  off:不接收消息
     */
    private String isOnOff;

    /**
     * system_jpush_config.ctime : 创建时间
     */
    private Date ctime;

    /**
     * system_jpush_config.admin_user_id : 用户ID:包括TAG用户、商户
     */
    private Integer adminUserId;

    private static final long serialVersionUID = 1L;

    public Integer getSystemJpushConfigId() {
        return systemJpushConfigId;
    }

    public void setSystemJpushConfigId(Integer systemJpushConfigId) {
        this.systemJpushConfigId = systemJpushConfigId;
    }

    public String getConfigApp() {
        return configApp;
    }

    public void setConfigApp(String configApp) {
        this.configApp = configApp == null ? null : configApp.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getIsOnOff() {
        return isOnOff;
    }

    public void setIsOnOff(String isOnOff) {
        this.isOnOff = isOnOff == null ? null : isOnOff.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }
}