package com.example.redis.repository;

import com.example.redis.dto.TaskDescriptionDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends CrudRepository<TaskDescriptionDTO, String> {
}
