package com.mydatabase.questRuleInstance.model;
import java.util.Date;
public class QuestRuleInstance {
    private String id;
    private String userId;
    private String questRuleId;
    private int status;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    public QuestRuleInstance(){}
    public QuestRuleInstance(String id, String userId, String questRuleId, int status, String createdBy, String updatedBy) {
        this.id = id;
        this.userId = userId;
        this.questRuleId = questRuleId;
        this.status = status;
        this.createdDate = new Date(); // 设置创建日期为当前日期
        this.createdBy = createdBy;
        this.updatedDate = new Date(); // 设置更新日期为当前日期
        this.updatedBy = updatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestRuleId() {
        return questRuleId;
    }

    public void setQuestRuleId(String questRuleId) {
        this.questRuleId = questRuleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
