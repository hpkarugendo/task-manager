package com.hpkarugendo.projects.taskmanager.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@ManyToOne
	private Department department;
	private char shift, frequency;
	private LocalDate onceOffDate;

	public Todo() {
		super();
	}

	public Todo(String name, Department department, char shift, char frequency) {
		super();
		this.name = name;
		this.department = department;
		this.shift = shift;
		this.frequency = frequency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public char getShift() {
		return shift;
	}

	public void setShift(char shift) {
		this.shift = shift;
	}

	public char getFrequency() {
		return frequency;
	}

	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	public LocalDate getOnceOffDate() {
		return onceOffDate;
	}

	public void setOnceOffDate(LocalDate onceOffDate) {
		this.onceOffDate = onceOffDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", department=" + department.getName() + ", shift=" + shift
				+ ", frequency=" + frequency + "]";
	}

}
