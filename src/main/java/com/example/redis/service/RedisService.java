package com.example.redis.service;

import com.example.redis.dto.TaskDTO;
import com.example.redis.repository.RedisRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisRepo redisRepo;

    @SneakyThrows
    public TaskDTO getResultAndSave (long id, long parameter){
        TaskDTO taskDTO = new TaskDTO(id, calculate(parameter));
        return redisRepo.save(taskDTO);
    }

    @SneakyThrows
    @Cacheable(value = "cacheable", key = "#id")
    public TaskDTO getCalculationTaskResult(long id, long parameter){
        return new TaskDTO(id, calculate(parameter));
    }

    @SneakyThrows
    private long calculate(long parameter){
        long randomMultiplier = new Random().nextLong();
        long calculatedResult = randomMultiplier * parameter;
        Thread.sleep(3000);
        return calculatedResult;
    }
}
