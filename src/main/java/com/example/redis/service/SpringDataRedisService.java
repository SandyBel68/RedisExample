package com.example.redis.service;

import com.example.redis.dto.TaskDTO;
import com.example.redis.repository.RedisRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpringDataRedisService {

    private final RedisRepo redisRepo;

    @SneakyThrows
    public TaskDTO saveToCache(Long param){
        TaskDTO newTask = new TaskDTO();
        newTask.setCalculatedResult(param);
        return redisRepo.save(newTask);
    }
}
