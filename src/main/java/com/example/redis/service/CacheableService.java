package com.example.redis.service;

import com.example.redis.dto.TaskDTO;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CacheableService {

    @SneakyThrows
    @Cacheable(value = "SimpleCaching")
    public TaskDTO getCalculationTaskResult(long parameter){
        long randomMultiplier = new Random().nextLong();
        long calculatedResult = randomMultiplier * parameter;
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCalculatedResult(calculatedResult);
        Thread.sleep(2000);
        return taskDTO;
    }
}
