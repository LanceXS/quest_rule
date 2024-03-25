package com.mydatabase.questRuleInstance.qRIservice;

import com.mydatabase.questRuleInstance.model.QuestRuleInstance;
import com.mydatabase.questRuleInstance.qRImapper.QRInstanceMapper;
import org.springframework.amqp.core.AmqpTemplate;
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



    //以下是为tasks做的
    private AmqpTemplate amqpTemplate;
    public void createQuestRuleInstanceForTasks(String iD, String userId, String questRuleId, String createdBy, String updatedBy){
        QuestRuleInstance questRuleInstance = new QuestRuleInstance();
        questRuleInstance.setId(iD);
        questRuleInstance.setUserId(userId);
        questRuleInstance.setQuestRuleId(questRuleId);
        questRuleInstance.setStatus(0);
        questRuleInstance.setCreatedBy(createdBy);
        questRuleInstance.setUpdatedBy(updatedBy);
        amqpTemplate.convertAndSend("quest_rule_instance_queue", questRuleInstance);
    }
    public void updateQuestRuleInstanceStatusfortasks(String userId, int status) {
        List<QuestRuleInstance> questRuleInstances = fetchQuestRuleInstances(userId);
        if (!questRuleInstances.isEmpty()) {
            QuestRuleInstance questRuleInstance = questRuleInstances.get(0);
            questRuleInstance.setStatus(status);
            qrInstanceMapper.updateQuestRuleInstanceStatus(questRuleInstance.getId(), status);
            // 发送消息
            amqpTemplate.convertAndSend("quest_rule_instance_queue", userId + ":" + status);
        }
    }
    private List<QuestRuleInstance> fetchQuestRuleInstances(String userId) {
        return qrInstanceMapper.getQuestRuleInstanceListByUserId(userId);
    }

    //The follow is for solving the problem of database performance, implement the sub-database sub-table
    @Autowired
    private QRInstanceMapper questRuleInstanceMapperforDAO;
    public List<QuestRuleInstance> getQuestRuleInstancesByUserId(String userId) {
        return questRuleInstanceMapperforDAO.getQuestRuleInstancesByUserIdforDAO(userId);
    }
}
