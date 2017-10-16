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
		System.out.println("Starting Home");
		return "home/default";
	}
	
	@GetMapping("upload")
	public String upload() {
		System.out.println("Starting Upload");
		return "home/upload";
	}
	
	@GetMapping("list")
	public String list() {
		System.out.println("Starting List");
		return "redirect:/tools";
	}
		
}