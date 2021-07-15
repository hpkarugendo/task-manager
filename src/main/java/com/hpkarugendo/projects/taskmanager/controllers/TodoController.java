package com.hpkarugendo.projects.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hpkarugendo.projects.taskmanager.entities.Todo;
import com.hpkarugendo.projects.taskmanager.services.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService toService;

	@PostMapping("todos/add")
	public String save(@ModelAttribute("todoObject") Todo todo, RedirectAttributes ra) {
		try {
			toService.save(todo);
			ra.addFlashAttribute("mOk", "Todo has been saved successfully!");
		} catch (Exception e) {
			ra.addFlashAttribute("todoObject", todo);
			ra.addFlashAttribute("mNo", "Error saving Todo: " + todo.getName().toUpperCase());
		}
		
		return "redirect:/manage";
	}
	
	@DeleteMapping("todos/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			toService.delete(id);
			ra.addFlashAttribute("mOk", "Todo with ID: " + id + " has been deleted!");
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", e.getMessage());
		}
		
		return "redirect:/manage";
	}
	
	@GetMapping("todos/edit/{id}")
	public String edit(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			ra.addFlashAttribute("todoObject", toService.getById(id));
		} catch (Exception e) {
			ra.addFlashAttribute("mNo", e.getMessage());
		}
		
		return "redirect:/manage";
	}
}
