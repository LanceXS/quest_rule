package com.mydatabase.questRuleInstance.qRIservice;

import com.mydatabase.questRuleInstance.model.QuestRuleInstance;
import com.mydatabase.questRuleInstance.qRImapper.QRInstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QRInstanceService {
    private final QRInstanceMapper qrInstanceMapper;
    @Autowired
    public QRInstanceService(QRInstanceMapper qriMapper){
        this.qrInstanceMapper = qriMapper;
    }
    public int getQuestRuleStatusById(String questRuleId) {
        return qrInstanceMapper.getQuestRuleStatusById(questRuleId);
    }
    public void createQuestRuleInstance(String iD, String userId, String questRuleId, String createdBy, String updatedBy){
        int questRuleStatus = getQuestRuleStatusById(questRuleId);
        if (questRuleStatus != 0) {
            throw new IllegalArgumentException("Only create tasks with shelf status");
        }
        QuestRuleInstance questRuleInstance = new QuestRuleInstance();
        questRuleInstance.setId(iD);
        questRuleInstance.setUserId(userId);
        questRuleInstance.setQuestRuleId(questRuleId);
        questRuleInstance.setStatus(0);
        questRuleInstance.setCreatedBy(createdBy);
        questRuleInstance.setUpdatedBy(updatedBy);

        qrInstanceMapper.createQuestRuleInstance(questRuleInstance);
    }
    public void deleteQuestRuleInstanceById(String id) {
        qrInstanceMapper.deleteQuestRuleInstanceById(id);
    }
    public void updateQuestRuleInstanceStatus(String userId, int status) {
        qrInstanceMapper.updateQuestRuleInstanceStatus(userId,status);
    }
    public List<QuestRuleInstance> getQuestRuleInstanceListByUserId(String userId) {
        return qrInstanceMapper.getQuestRuleInstanceListByUserId(userId);
    }
}
