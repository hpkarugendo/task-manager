package com.hpkarugendo.projects.taskmanager.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.taskmanager.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
	void deleteById(Long id);
	List<Department> findAll();
	Optional<Department> findByName(String name);
}
