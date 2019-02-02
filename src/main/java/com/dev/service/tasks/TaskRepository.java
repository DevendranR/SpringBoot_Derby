package com.dev.service.tasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer>{
	public List<TaskEntity> findByProjectBelonged(String projectBelonged);
}
