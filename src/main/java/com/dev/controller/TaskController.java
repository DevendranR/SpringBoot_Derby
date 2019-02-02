package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev.service.employee.Employee;
import com.dev.service.employee.EmployeeService;
import com.dev.service.projects.ProjectService;
import com.dev.service.projects.Projects;
import com.dev.service.tasks.TaskService;
import com.dev.service.tasks.Tasks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class TaskController {
	@Autowired
	@Qualifier("projectService")
	 private ProjectService projectService;
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	@Autowired
	@Qualifier("taskService")
	 private TaskService taskService;
	@RequestMapping("/")
	public String welcome() {

		   projectService.persistProject();
		   employeeService.persistEmployee();
		return "index";
	}
	
   @RequestMapping(value = "/task", method = RequestMethod.GET)
   public ModelAndView task() {
      return new ModelAndView("task", "command", new Tasks());
   }
   @RequestMapping(value = "/viewTasks/{projectId}", method = RequestMethod.GET)
   public ModelAndView viewTasks(@PathVariable("projectId") String projectId,ModelMap model) {
	   List<Tasks> allTasks = new ArrayList<Tasks>();
		try {
			allTasks   =  taskService.fetchTaskByProjects(projectId);
			
			model.addAttribute("allTasks", allTasks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return new ModelAndView("viewTasks", "command", new Tasks());
   }
	
   @RequestMapping(value = "/addTask", method = RequestMethod.POST)
      public String addTask(@ModelAttribute("SpringWeb")Tasks task,ModelMap model) {

      model.addAttribute("taskName", task.getTaskName());
      model.addAttribute("projectBelonged", task.getProjectBelonged());
      model.addAttribute("employeesAssigned", task.getEmployeesAssigned());
      model.addAttribute("taskStartDate", task.getTaskStartDate());
      model.addAttribute("taskEnddate", task.getTaskEnddate());
      try {
		taskService.assignTasks(task);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //allTasks.add(task);
      return "result2";
   }
   
   @ModelAttribute("projectList")
   public List<Projects> getProjectList() {
	   List<Projects> projectList = new ArrayList<Projects>();
	try {
		 projectList = projectService.fetchAllProjects();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
      return projectList;
   }
   @RequestMapping(value = "/employeesList/{projectId}", method = RequestMethod.GET)
   public @ResponseBody  String getAllEmployees(@PathVariable("projectId") String projectId) {
	   String value2 = "";
       System.out.println("projectId"+projectId);
       GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("dd-MM-yyyy");
		Gson gson = gsonBuilder.create();
	try {
		List<Employee> val  =  employeeService.fetchEmployeeByProject(projectId);
		value2 = gson.toJson(val);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       return value2 ;
   }
}
