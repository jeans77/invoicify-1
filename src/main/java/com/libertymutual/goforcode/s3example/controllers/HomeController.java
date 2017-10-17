package com.libertymutual.goforcode.s3example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	public HomeController() {
	}

	@GetMapping("")
	public String home() {
		System.out.println("HomeController:");
		return "home/default";
	}
	
	@GetMapping("upload")
	public String upload() {
		System.out.println("HomeController: Upload");
		return "home/upload";
	}
	
	@GetMapping("create")
	public String create() {
		System.out.println("HomeController: Create");
		return "home/create";
	}
	
	@GetMapping("list")
	public String list() {
		System.out.println("HomeController: List");
		return "redirect:/tools";
	}
		
}