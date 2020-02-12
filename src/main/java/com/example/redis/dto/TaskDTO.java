package com.example.redis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@NoArgsConstructor
@Data
@RedisHash("new")
public class TaskDTO implements Serializable {
    @Id
    private long calculatedResult;
}
