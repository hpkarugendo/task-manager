package com.hpkarugendo.projects.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hpkarugendo.projects.taskmanager.entities.Employee;
import com.hpkarugendo.projects.taskmanager.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService eService;
	
	@PostMapping("employees/add")
	public String save(@ModelAttribute("empObject") Employee employee, RedirectAttributes ra) {
		try {
			eService.save(employee);
			ra.addFlashAttribute("mOk", "Employee saved Successfully!");
		} catch (Exception e) {
			ra.addFlashAttribute("empObject", employee);
			ra.addFlashAttribute("mNo", "Error Saving Employee: " + employee.getName() + "!");
		}
		
		return "redirect:/manage";
	}
	
	@DeleteMapping("employees/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			eService.delete(id);
			ra.addFlashAttribute("mOk", "Employee deleted successfully!");
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", "Error Deleting Employee with ID: " + id + "!");
		}
		
		return "redirect:/manage";
	}
	
	@GetMapping("employees/edit/{id}")
	public String edit(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			ra.addFlashAttribute("empObject", eService.getById(id));
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", "Employee with ID: " + id + " was not found!");
		}
		
		return "redirect:/manage";
	}
}
