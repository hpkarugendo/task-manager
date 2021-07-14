package com.hpkarugendo.projects.taskmanager.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findAll();
	Optional<Employee> findByUsername(String username);
	List<Employee> findByDepartment(Department department);
	void deleteById(Long id);
}
