package com.mydatabase.award.model;
import java.math.BigDecimal;

public class Award {
    private String id;
    private String userId;
    private String awardRuleId;
    private BigDecimal amount;
    private int awardType;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;

    public Award() {
    }

    public Award(String id, String userId, String awardRuleId, BigDecimal amount, Integer awardType,
                 String createdDate, String createdBy, String updatedDate, String updatedBy) {
        this.id = id;
        this.userId = userId;
        this.awardRuleId = awardRuleId;
        this.amount = amount;
        this.awardType = awardType;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAwardRuleId() {
        return awardRuleId;
    }

    public void setAwardRuleId(String awardRuleId) {
        this.awardRuleId = awardRuleId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
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
