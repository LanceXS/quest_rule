package com.mydatabase.awardrule.model;
import java.math.BigDecimal;

public class AwardRule {
    private String id;
    private String questRuleId;
    private BigDecimal amount;
    private int awardType;
    private int status;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    public AwardRule() {
    }

    public AwardRule(String id, String questRuleId, BigDecimal amount, int awardType, int status,
                     String createdDate, String createdBy, String updatedDate, String updatedBy) {
        this.id = id;
        this.questRuleId = questRuleId;
        this.amount = amount;
        this.awardType = awardType;
        this.status = status;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestRuleId() {
        return questRuleId;
    }

    public void setQuestRuleId(String questRuleId) {
        this.questRuleId = questRuleId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getAwardType() {
        return awardType;
    }

    public void setAwardType(int awardType) {
        this.awardType = awardType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
