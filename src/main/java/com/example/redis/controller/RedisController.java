package com.example.redis.controller;

import com.example.redis.dto.TaskDTO;
import com.example.redis.repository.RedisRepo;
import com.example.redis.service.CacheableService;
import com.example.redis.service.SpringDataRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController("/cache")
public class RedisController {

    private final CacheableService cacheableService;
    private final SpringDataRedisService springDataRedisService;
    private final RedisRepo redisRepo;

    @GetMapping("/save/cacheable")
    public TaskDTO cacheWithCacheable(long param){
        return cacheableService.getCalculationTaskResult(param);
    }

    @GetMapping("/save/springdata")
    public TaskDTO cacheDescription(long param){
        return springDataRedisService.saveToCache(param);
    }

    @GetMapping("/get")
    public TaskDTO getDescription(long param){
        Optional<TaskDTO> task = redisRepo.findById(param);
        return task.get();
    }
}
