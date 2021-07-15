package com.hpkarugendo.projects.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Employee;
import com.hpkarugendo.projects.taskmanager.repos.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo eRepo;
	
	public List<Employee> getAll(){
		return eRepo.findAll();
	}
	
	public List<Employee> getAllByDepartment(Department department){
		return eRepo.findByDepartment(department);
	}
	
	public Employee getById(Long id) {
		Optional<Employee> ans = eRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Employee with ID: " + id + " was not found!");
		}
	}
	
	public Employee getByUsername(String username) {
		Optional<Employee> ans = eRepo.findByUsername(username);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			throw new DataAccessResourceFailureException("Employee with Username: " + username + " was not found!");
		}
	}
	
	public Employee save(Employee employee) {
		return eRepo.save(employee);
	}
	
	public void delete(Long id) {
		try {
			eRepo.deleteById(id);
		} catch (Exception e) {
			throw new DataAccessResourceFailureException("Error Deleting Employee with ID: " + id + "!");
		}
	}
}
