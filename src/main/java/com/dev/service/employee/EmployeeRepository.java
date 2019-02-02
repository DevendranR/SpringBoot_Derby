package com.dev.service.employee;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String>{
	public List<EmployeeEntity> findByprojectBelonged(String projectBelonged);
	public List<EmployeeEntity> findByemployeeId(String employeeId);
}
