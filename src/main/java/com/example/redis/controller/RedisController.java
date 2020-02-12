package com.example.redis.controller;

import com.example.redis.dto.TaskDTO;
import com.example.redis.repository.RedisRepo;
import com.example.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController("/cache")
public class RedisController {

    private final RedisService redisService;
    private final RedisRepo redisRepo;

    @GetMapping("/cacheable")
    public TaskDTO cacheWithCacheable(long id, long param){
        return redisService.getCalculationTaskResult(id, param);
    }

    @GetMapping("/springdata")
    public TaskDTO cacheSpringData(long id, long param){
        return redisService.getResultAndSave(id, param);
    }

    @GetMapping("/get")
    public TaskDTO getWithSpringData(long id){
        Optional<TaskDTO> task = redisRepo.findById(id);
        return task.orElse(null);
    }
}
