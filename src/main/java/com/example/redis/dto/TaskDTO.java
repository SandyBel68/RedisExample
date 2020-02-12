package com.example.redis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDTO implements Serializable {
    private long calculatedResult;
}
