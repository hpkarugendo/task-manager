package com.hpkarugendo.projects.taskmanager.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDate date;
	@ManyToOne
	private Todo todo;
	private boolean done;
	@ManyToOne
	private Employee employee;
	public Task() {
		super();
	}
	public Task(LocalDate date, Todo todo, boolean done, Employee employee) {
		super();
		this.date = date;
		this.todo = todo;
		this.done = done;
		this.employee = employee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Todo getTodo() {
		return todo;
	}
	public void setTodo(Todo todo) {
		this.todo = todo;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", date=" + date + ", todo=" + todo.getName() + ", done=" + done + ", employee=" + employee.getName()
				+ "]";
	}
	
	
	
}
