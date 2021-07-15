package com.hpkarugendo.projects.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hpkarugendo.projects.taskmanager.entities.Department;
import com.hpkarugendo.projects.taskmanager.services.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService dService;
	
	@DeleteMapping("departments/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			dService.delete(id);
			ra.addFlashAttribute("mOk", "Department with ID: " + id + " has been deleted!");
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", e.getMessage());
		}
		
		return "redirect:/manage";
	}
	
	@PostMapping("departments/add")
	public String save(@ModelAttribute("deptObject") Department department, RedirectAttributes ra) {
		try {
			dService.save(department);
			ra.addFlashAttribute("mOk", "Department Saved Successfully!");
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", "Error Saving Department with name: " + department.getName().toUpperCase() + "!");
		}
		
		return "redirect:/manage";
	}
		
}
