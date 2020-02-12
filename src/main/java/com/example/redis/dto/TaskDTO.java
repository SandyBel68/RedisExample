package com.example.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("springdata")
public class TaskDTO implements Serializable {
    @Id
    private long id;
    private long calculatedResult;
}
