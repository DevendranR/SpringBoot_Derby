package com.dev.service.tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.service.employee.EmployeeEntity;
import com.dev.service.employee.EmployeeRepository;
import com.dev.util.DateConverter;

@Service
public class TaskService {
	@Autowired
	TaskRepository repository;
	@Autowired
	EmployeeRepository employeeRepository;
	public List<Tasks> fetchTaskByProjects(String projectBelonged) {
		if("ALL_PROJECTS".equals(projectBelonged)){
			List<Tasks> li = new ArrayList<Tasks>();
			Iterable<TaskEntity> val = repository.findAll();
			for (TaskEntity taskEntity : val) {
				Tasks tasks = new Tasks();
				tasks.setTaskId(taskEntity.getTaskId());
				tasks.setTaskName(taskEntity.getTaskName());
				tasks.setTaskStartDate(DateConverter.convertDateToString(taskEntity.getTaskStartDate()));
				tasks.setTaskEnddate(DateConverter.convertDateToString(taskEntity.getTaskEnddate()));
				tasks.setProjectBelonged(taskEntity.getProjectBelonged());
				li.add(tasks);
			}
			return li;
		}else{
			List<TaskEntity> taskList = repository.findByProjectBelonged(projectBelonged);
			List<Tasks> tList = new ArrayList<>();
			for (TaskEntity task : taskList) {
				Tasks task2 = new Tasks();
				task2.setTaskId(task.getTaskId());
				task2.setTaskName(task.getTaskName());
				task2.setTaskStartDate(DateConverter.convertDateToString(task.getTaskStartDate()));
				task2.setTaskEnddate(DateConverter.convertDateToString(task.getTaskEnddate()));
				task2.setProjectBelonged(task.getProjectBelonged());
				Set<String> empSet = new HashSet<>();
				for (EmployeeEntity emps : task.getEmployees()) {
					
					empSet.add(emps.getEmployeeId());
				}
				task2.setEmployeesAssigned(empSet);
				tList.add(task2);
			}
			return tList;
		}
		
	}

	public void assignTasks(Tasks task) throws Exception {
		TaskEntity taskEntity= new TaskEntity();
		taskEntity.setTaskName(task.getTaskName());
		taskEntity.setTaskStartDate(DateConverter.convertStringToDate(task.getTaskStartDate()));
		taskEntity.setTaskEnddate(DateConverter.convertStringToDate(task.getTaskEnddate()));
		taskEntity.setProjectBelonged(task.getProjectBelonged());
		Set<EmployeeEntity> empSet = new HashSet<EmployeeEntity>();
		for (String employeeId : task.getEmployeesAssigned()) {
			EmployeeEntity emp = employeeRepository.findByemployeeId(employeeId).get(0);
			empSet.add(emp);
		}
		taskEntity.setEmployees(empSet);
		repository.save(taskEntity);
		
	}

}
