package com.dev.service.employee;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.dev.service.tasks.TaskEntity;

@Entity
public class EmployeeEntity {
	@Id
	private String employeeId;
	private String employeeName;
	private String projectBelonged;
	@ManyToMany(mappedBy = "employees")
	private Set<TaskEntity> tasks = new HashSet<TaskEntity>();

	public Set<TaskEntity> getTasks() {
		return tasks;
	}
	public void setTasks(Set<TaskEntity> tasks) {
		this.tasks = tasks;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getProjectBelonged() {
		return projectBelonged;
	}
	public void setProjectBelonged(String projectBelonged) {
		this.projectBelonged = projectBelonged;
	}

	
	
}

