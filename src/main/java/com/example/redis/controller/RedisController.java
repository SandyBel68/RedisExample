package com.example.redis.controller;

import com.example.redis.dto.TaskDTO;
import com.example.redis.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/cache")
public class RedisController {

    @Autowired
    private SimpleService simpleService;

    @GetMapping("/cacheable")
    public TaskDTO cacheWithCacheable(long param){
        Optional<TaskDTO> result = simpleService.getCalculationTaskResult(param);
        return result.orElse(new TaskDTO());
    }
}
