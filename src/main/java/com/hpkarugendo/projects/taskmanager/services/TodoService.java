package com.hpkarugendo.projects.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Todo;
import com.hpkarugendo.projects.taskmanager.repos.TodoRepo;

@Service
public class TodoService {
	@Autowired
	private TodoRepo toRepo;
	
	public List<Todo> getAll(){
		return toRepo.findAll();
	}
	
	public List<Todo> getAllByDepartment(Department department){
		return toRepo.findByDepartment(department);
	}
	
	public Todo getByName(String name) {
		Optional<Todo> ans = toRepo.findByNameIgnoreCase(name);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Todo with NAME: " + name + " : was not found!");
		}
	}
	
	public Todo getById(Long id) {
		Optional<Todo> ans = toRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Todo with ID: " + id + " : was not found!");
		}
	}
	
	public Todo save(Todo todo) {
		return toRepo.save(todo);
	}
	
	public void delete(Long id) {
		try {
			toRepo.existsById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException("Error Deleting Todo with ID: " + id + "!");
		}
	}

}
