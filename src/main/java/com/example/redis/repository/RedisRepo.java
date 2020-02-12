package com.example.redis.repository;

import com.example.redis.dto.TaskDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends CrudRepository<TaskDTO, Long> {
}
