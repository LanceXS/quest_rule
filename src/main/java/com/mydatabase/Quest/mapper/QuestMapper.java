package com.mydatabase.Quest.mapper;
import com.mydatabase.Quest.model.Quest;

import java.util.List;

public interface QuestMapper {
    List<Quest> findAllQuests();
}
