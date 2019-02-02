package com.dev.service.employee;

import java.util.Set;

import com.dev.service.tasks.Tasks;

public class Employee {
	private String employeeId;
	private String employeeName;
	private String projectBelonged;
	private Set<Tasks> taskAssigned;
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
	public Set<Tasks> getTaskAssigned() {
		return taskAssigned;
	}
	public void setTaskAssigned(Set<Tasks> taskAssigned) {
		this.taskAssigned = taskAssigned;
	}
	
	
}
