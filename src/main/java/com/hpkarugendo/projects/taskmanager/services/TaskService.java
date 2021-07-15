package com.hpkarugendo.projects.taskmanager.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Employee;
import com.hpkarugendo.projects.taskmanager.entities.Task;
import com.hpkarugendo.projects.taskmanager.repos.TaskRepo;

@Service
public class TaskService {
	@Autowired
	private TaskRepo tRepo;
	
	public List<Task> getAll(){
		return tRepo.findAll();
	}
	
	public List<Task> getByDate(LocalDate date){
		return tRepo.findByDate(date);
	}
	
	public List<Task> getByDateAndEmployee(LocalDate date, Employee employee){
		return tRepo.findByDateAndEmployee(date, employee);
	}
	
	public List<Task> getByDepartment(Department department){
		return tRepo.findByDepartment(department);
	}
	
	public List<Task> getByDateAndDeptAndDone(LocalDate date, Department department, boolean done){
		return tRepo.findByDateAndDepartmentAndDone(date, department, done);
	}
	
	public Task save(Task task) {
		return tRepo.save(task);
	}
	
	public Task getById(Long id) {
		Optional<Task> ans = tRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Task with ID: " + id + " was not found!");
		}
	}
	
	public void delete(Long id) {
		try {
			tRepo.deleteById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException("Error Deleting Task with ID: " + id + "!");
		}
	}
	
	public List<Task> buildTaskList(){
		List<Task> taskList = new ArrayList<Task>();
		
		return taskList;
	}

}
