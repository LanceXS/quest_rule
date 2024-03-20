package com.mydatabase.Quest.service;

import com.mydatabase.Quest.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class QuestService {
    private static final String QUEST_HASH_KEY = "quests";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private Lock cacheUpdateLock = new ReentrantLock();
    private HashOperations<String, String, Quest> hashOperations;
    @Autowired
    public QuestService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }
    public void saveQuest(Quest quest) {
        hashOperations.put(QUEST_HASH_KEY, quest.getId(), quest);
    }
    public Quest findQuestById(String id) {
        return hashOperations.get(QUEST_HASH_KEY, id);
    }
    public List<Quest> findAllQuests() {
        String cacheKey = "allQuests";
        List<Quest> quests = (List<Quest>) redisTemplate.opsForValue().get(cacheKey);
        if (quests == null) {
            // 处理缓存击穿(互斥锁)
            cacheUpdateLock.lock();
            try {
                quests = (List<Quest>) redisTemplate.opsForValue().get(cacheKey);
                if (quests == null) {
                    // 查询数据库
                    quests = Collections.emptyList();
                    redisTemplate.opsForValue().set(cacheKey, quests, Duration.ofMinutes(1));
                }
            } finally {
                cacheUpdateLock.unlock();
            }
        }
        return quests;
    }
    public void deleteQuestById(String id) {
        hashOperations.delete(QUEST_HASH_KEY, id);
    }
}
