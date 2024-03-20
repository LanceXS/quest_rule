package com.mydatabase.questRuleInstance.qRIConsumer;

import com.mydatabase.questRuleInstance.model.QuestRuleInstance;
import com.mydatabase.questRuleInstance.qRImapper.QRInstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class QRIconsumer {
    @Autowired
    private QRInstanceMapper qrInstanceMapper;
    @RabbitListener(queues = "quest_rule_instance_queue")
    public void handleMessage(QuestRuleInstance questRuleInstance) {
        qrInstanceMapper.createQuestRuleInstance(questRuleInstance);
    }
    @RabbitListener(queues = "quest_rule_instance_queue")
    public void handleMessage(String message) {
        String[] parts = message.split(":");
        String userId = parts[0];
        int status = Integer.parseInt(parts[1]);
        qrInstanceMapper.updateQuestRuleInstanceStatus(userId, status);
    }
}
