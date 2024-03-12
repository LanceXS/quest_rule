package com.mydatabase.awardrule.service;
import com.mydatabase.awardrule.mapper.AwardRuleMapper;
import com.mydatabase.awardrule.model.AwardRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardRuleService {
    private final AwardRuleMapper awardRuleMapper;

    @Autowired
    public AwardRuleService(AwardRuleMapper awardRuleMapper) {
        this.awardRuleMapper = awardRuleMapper;
    }

    public void insertAwardRule(AwardRule awardRule) {
        awardRuleMapper.insertAwardRule(awardRule);
    }

    public void deleteAwardRuleById(String id) {
        awardRuleMapper.deleteAwardRuleById(id);
    }

    public void updateAwardRule(AwardRule awardRule) {
        awardRuleMapper.updateAwardRule(awardRule);
    }

    public AwardRule findAwardRuleById(String id) {
        return awardRuleMapper.findAwardRuleById(id);
    }

    public List<AwardRule> findAllAwardRules() {
        return awardRuleMapper.findAllAwardRules();
    }
}
