package com.hpkarugendo.projects.taskmanager.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("taskListObject", new ArrayList<String>());
		return "index";
	}

}
