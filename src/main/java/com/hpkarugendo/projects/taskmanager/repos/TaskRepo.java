package com.hpkarugendo.projects.taskmanager.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Employee;
import com.hpkarugendo.projects.taskmanager.entities.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
	List<Task> findAll();
	List<Task> findByDate(LocalDate date);
	void deleteById(Long id);
	List<Task> findByEmployee(Employee employee);
	List<Task> findByDateAndEmployee(LocalDate date, Employee employee);
	List<Task> findByDepartment(Department department);
	List<Task> findByDateAndDepartmentAndDone(LocalDate date, Department department, boolean done);
}
