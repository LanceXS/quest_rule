package com.mydatabase.questRule.service;
import com.mydatabase.questRule.mapper.QRMapper;
import com.mydatabase.questRule.model.QuestRule;

import java.util.List;

public class QRService {
    private final QRMapper mapper;
    public QRService(QRMapper qrMapper) {
        this.mapper = qrMapper;
    }
    public void createQR(QuestRule questRule) {
        mapper.insertQuestRule(questRule);
    }
    public void deleteQRById(String id) {
        mapper.deleteQuestRuleById(id);
    }

    public QuestRule getQRById(String id) {
        return mapper.selectQuestRuleById(id);
    }

    public void updateQRStatus(String id, int status) {
        mapper.updateQuestRuleStatus(id, status);
    }

    public List<QuestRule> getAllQR() {
        return mapper.selectAllQuestRules();
    }

    // 根据状态获取任务列表
    public List<QuestRule> getQRListByStatus(int status) {
        return mapper.getQRListByStatus(status);
    }
}
