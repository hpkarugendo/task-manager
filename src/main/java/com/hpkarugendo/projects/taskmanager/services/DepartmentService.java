package com.hpkarugendo.projects.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.repos.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo dRepo;
	
	public List<Department> getAll(){
		return dRepo.findAll();
	}
	
	public Department getById(Long id) {
		Optional<Department> ans = dRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Department with ID: " + id + " was not found!");
		}
	}
	
	public Department getByName(String name) {
		Optional<Department> ans = dRepo.findByName(name);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Department with NAME: " + name + " was not found!");
		}
	}
	
	public Department save(Department department) {
		return dRepo.save(department);
	}
	
	public void delete(Long id) {
		try {
			dRepo.deleteById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException("Error Deleting Department with ID: " + id + "!");
		}
	}
	
}
