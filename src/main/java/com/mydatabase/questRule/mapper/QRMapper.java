package com.mydatabase.questRule.mapper;

import com.mydatabase.questRule.model.QuestRule;

import java.util.List;

public interface QRMapper {
    void insertQuestRule(QuestRule questRule);
    void deleteQuestRuleById(String id);
    QuestRule selectQuestRuleById(String id);
    void updateQuestRuleStatus(String id, int status);
    List<QuestRule> selectAllQuestRules();
    List<QuestRule> getQRListByStatus(int status);
}
