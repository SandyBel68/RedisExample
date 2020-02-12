package com.example.redis.service;

import com.example.redis.dto.TaskDescriptionDTO;
import com.example.redis.repository.RedisRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpringDataRedisService {

    private final RedisRepo redisRepo;

    public TaskDescriptionDTO saveToCache(String id, String description){
       TaskDescriptionDTO newTask = new TaskDescriptionDTO(id, description);
       return redisRepo.save(newTask);
    }
}
