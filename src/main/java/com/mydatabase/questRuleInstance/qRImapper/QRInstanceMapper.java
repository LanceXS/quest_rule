package com.mydatabase.questRuleInstance.qRImapper;
import com.mydatabase.questRuleInstance.model.QuestRuleInstance;
import org.apache.ibatis.annotations.*;
import java.util.List;
//import QuestRuleInstance;
public interface QRInstanceMapper {
    @Insert("INSERT INTO quest_rule_instance (user_id, quest_rule_id, status, created_date, created_by, updated_date, updated_by) " +
            "VALUES (#{userId}, #{questRuleId}, #{status}, NOW(), #{createdBy}, NOW(), #{updatedBy})")
    void createQuestRuleInstance(QuestRuleInstance questRuleInstance);
    @Delete("DELETE FROM quest_rule_instance WHERE id = #{id}")
    void deleteQuestRuleInstanceById(String id);
    @Update("UPDATE quest_rule_instance SET status = #{status} WHERE id = #{id}")
    void updateQuestRuleInstanceStatus(@Param("id") String id, @Param("status") int status);
    @Select("SELECT * FROM quest_rule_instance WHERE user_id = #{userId}")
    List<QuestRuleInstance> getQuestRuleInstanceListByUserId(String userId);
    @Select("SELECT status FROM quest_rule_instance WHERE quest_rule_id = #{questRuleId}")
    int getQuestRuleStatusById(String questRuleId);

    @Select("SELECT * FROM quest_rule_instance WHERE user_id = #{userId}")
    List<QuestRuleInstance> getQuestRuleInstancesByUserIdforDAO(@Param("userId") String userId);
}
