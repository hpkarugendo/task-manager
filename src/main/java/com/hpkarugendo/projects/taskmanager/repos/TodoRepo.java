package com.hpkarugendo.projects.taskmanager.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.entities.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long>{
	List<Todo> findAll();
	Optional<Todo> findByNameIgnoreCase(String name);
	void deleteById(Long id);
	List<Todo> findByDepartment(Department department);
}
