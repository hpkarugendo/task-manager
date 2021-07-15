package com.hpkarugendo.projects.taskmanager.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Employee;
import com.hpkarugendo.projects.taskmanager.entities.Todo;
import com.hpkarugendo.projects.taskmanager.services.DepartmentService;
import com.hpkarugendo.projects.taskmanager.services.EmployeeService;
import com.hpkarugendo.projects.taskmanager.services.TaskService;
import com.hpkarugendo.projects.taskmanager.services.TodoService;

@Controller
public class MainController {
	@Autowired
	private DepartmentService dService;
	@Autowired
	private EmployeeService eService;
	@Autowired
	private TaskService taService;
	@Autowired
	private TodoService toService;
	
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("taskListObject", new ArrayList<String>());
		return "index";
	}
	
	@GetMapping("/manage")
	public String dash(Model m) {
		m.addAttribute("employees", eService.getAll());
		if(!m.containsAttribute("empObject")) {
			m.addAttribute("empObject", new Employee());
		}
		m.addAttribute("depts", dService.getAll());
		if(!m.containsAttribute("deptObject")) {
			m.addAttribute("deptObject", new Department());
		}
		m.addAttribute("tasks", taService.getAll());
		m.addAttribute("todos", toService.getAll());
		if(!m.containsAttribute("todoObject")) {
			m.addAttribute("todoObject", new Todo());
		}
		return "dashboard";
	}
}
