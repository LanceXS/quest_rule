package com.mydatabase.awardrule.mapper;
import org.apache.ibatis.annotations.*;
import java.util.List;
import com.mydatabase.awardrule.model.AwardRule;
public interface AwardRuleMapper {
    @Insert("INSERT INTO award_rule (id, quest_rule_id, amount, award_type, status, created_date, created_by, updated_date, updated_by) VALUES (#{id}, #{questRuleId}, #{amount}, #{awardType}, #{status}, #{createdDate}, #{createdBy}, #{updatedDate}, #{updatedBy})")
    void insertAwardRule(AwardRule awardRule);
    @Delete("DELETE FROM award_rule WHERE id = #{id}")
    void deleteAwardRuleById(String id);
    @Update("UPDATE award_rule SET quest_rule_id = #{questRuleId}, amount = #{amount}, " +
            "award_type = #{awardType}, status = #{status}, created_date = #{createdDate}, created_by = #{createdBy}, " +
            "updated_date = #{updatedDate}, updated_by = #{updatedBy} WHERE id = #{id}")
    void updateAwardRule(AwardRule awardRule);
    @Select("SELECT * FROM award_rule WHERE id = #{id}")
    AwardRule findAwardRuleById(String id);
    @Select("SELECT * FROM award_rule")
    List<AwardRule> findAllAwardRules();
}
