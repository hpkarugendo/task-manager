package com.hpkarugendo.projects.taskmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	private String name, password, position;
	@ManyToOne
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String username, String name, String password, String position, Department department) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.position = position;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", position=" + position + ", department=" + department.getName() + "]";
	}

}
