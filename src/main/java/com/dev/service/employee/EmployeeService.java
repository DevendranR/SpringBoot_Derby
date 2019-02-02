package com.dev.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> fetchEmployeeByProject(String projectBelonged) {
		// TODO Auto-generated method stub
		List<EmployeeEntity> val = employeeRepository.findByprojectBelonged(projectBelonged);
		List<Employee> li = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : val) {
			Employee e = new Employee();
			e.setEmployeeId(employeeEntity.getEmployeeId());
			e.setEmployeeName(employeeEntity.getEmployeeName());
			e.setProjectBelonged(employeeEntity.getProjectBelonged());
			li.add(e);
		}
		return li;
	}
	
	public void persistEmployee(){
		EmployeeEntity e1 = new EmployeeEntity();
		e1.setEmployeeId("emp1");
		e1.setEmployeeName("Jack");
		e1.setProjectBelonged("Project1");
		EmployeeEntity e2 = new EmployeeEntity();
		e2.setEmployeeId("emp2");
		e2.setEmployeeName("John");
		e2.setProjectBelonged("Project2");
		EmployeeEntity e3 = new EmployeeEntity();
		e3.setEmployeeId("emp3");
		e3.setEmployeeName("Jim");
		e3.setProjectBelonged("Project1");
		EmployeeEntity e4 = new EmployeeEntity();
		e4.setEmployeeId("emp4");
		e4.setEmployeeName("Johnny");
		e4.setProjectBelonged("Project2");
		employeeRepository.save(e1);
		employeeRepository.save(e2);
		employeeRepository.save(e3);
		employeeRepository.save(e4);
	}

}
