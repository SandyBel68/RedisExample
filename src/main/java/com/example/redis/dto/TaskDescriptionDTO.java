package com.example.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("description")
public class TaskDescriptionDTO implements Serializable {
    private String id;
    private String description;
}
