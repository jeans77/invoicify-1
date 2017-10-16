package com.libertymutual.goforcode.s3example.api;

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
		return "home/default";
	}
	
	@GetMapping("upload")
	public String upload() {
		return "home/upload";
	}
	
	@GetMapping("list")
	public String list() {
		return "home/list";
	}
		
}