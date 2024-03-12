package com.mydatabase.award.mapper;
import org.apache.ibatis.annotations.*;
import java.util.List;
import com.mydatabase.award.model.Award;

public interface AwardMapper {
    @Insert("INSERT INTO award (id, user_id, award_rule_id, amount, award_type, created_date, created_by, updated_date, updated_by) VALUES (#{id}, #{userId}, #{awardRuleId}, #{amount}, #{awardType}, #{createdDate}, #{createdBy}, #{updatedDate}, #{updatedBy})")
    void insertAward(Award award);
    @Delete("DELETE FROM award WHERE id = #{id}")
    void deleteAwardById(String id);
    @Update("UPDATE award SET user_id = #{userId}, award_rule_id = #{awardRuleId}, amount = #{amount}, " +
            "award_type = #{awardType}, created_date = #{createdDate}, created_by = #{createdBy}, " +
            "updated_date = #{updatedDate}, updated_by = #{updatedBy} WHERE id = #{id}")
    void updateAward(Award award);
    @Select("SELECT * FROM award WHERE id = #{id}")
    Award findAwardById(String id);
    @Select("SELECT * FROM award")
    List<Award> findAllAwards();
}
