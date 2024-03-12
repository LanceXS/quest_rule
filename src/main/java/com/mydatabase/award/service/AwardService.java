package com.mydatabase.award.service;
import com.mydatabase.award.mapper.AwardMapper;
import com.mydatabase.award.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    private final AwardMapper awardMapper;

    @Autowired
    public AwardService(AwardMapper awardMapper) {
        this.awardMapper = awardMapper;
    }
    public void insertAward(Award award) {
        awardMapper.insertAward(award);
    }
    public void deleteAwardById(String id) {
        awardMapper.deleteAwardById(id);
    }
    public void updateAward(Award award) {
        awardMapper.updateAward(award);
    }
    public Award findAwardById(String id) {
        return awardMapper.findAwardById(id);
    }
    public List<Award> findAllAwards() {
        return awardMapper.findAllAwards();
    }
}