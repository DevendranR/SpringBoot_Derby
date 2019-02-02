 package com.dev.service.tasks;

import java.util.Set;

public class Tasks {
	private Integer taskId;
	private String taskName;
	private String taskStartDate;
	private String taskEnddate;
	private Set<String> employeesAssigned;
	private String projectBelonged;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public String getTaskEnddate() {
		return taskEnddate;
	}
	public void setTaskEnddate(String taskEnddate) {
		this.taskEnddate = taskEnddate;
	}
	public Set<String> getEmployeesAssigned() {
		return employeesAssigned;
	}
	public void setEmployeesAssigned(Set<String> employeesAssigned) {
		this.employeesAssigned = employeesAssigned;
	}
	public String getProjectBelonged() {
		return projectBelonged;
	}
	public void setProjectBelonged(String projectBelonged) {
		this.projectBelonged = projectBelonged;
	}
	
	
	
}
