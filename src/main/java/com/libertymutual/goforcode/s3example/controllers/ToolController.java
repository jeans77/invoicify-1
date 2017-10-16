package com.libertymutual.goforcode.s3example.controllers;

import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.s3example.models.Tool;
import com.libertymutual.goforcode.s3example.repositories.ToolRepo;


	@Controller
	@RequestMapping("/tools")
	public class ToolController {

		@Autowired
		private ToolRepo toolRepo;

		public ToolController(ToolRepo toolRepo) {
			this.toolRepo = toolRepo;
		}

		@GetMapping("")
//		public List<Tool> getAll() {
//			return toolRepo.findAll();
		public ModelAndView showDefault() {
		System.out.println("Starting ToolList");
		ModelAndView mv = new ModelAndView("home/list");
		mv.addObject("tools", toolRepo.findAll());
		return mv;
		}
		
		@GetMapping("/{id}")
		public Tool getOneTool(@PathVariable long id) {
			return toolRepo.findOne(id);
		}

		@PostMapping("")
//		public Tool createTool(@RequestBody Tool tool) {
		public String createTool(String name, String description, String image) {
			Tool tool = new Tool(name, description, image);
			toolRepo.save(tool);
			return "redirect:/tools";
		}
		
		@PutMapping("{id}")
		public Tool updateTool(@RequestBody Tool tool, @PathVariable long id) {
			tool.setId(id);
			return toolRepo.save(tool);
		}
	
}

