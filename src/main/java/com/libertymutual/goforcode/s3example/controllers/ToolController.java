package com.libertymutual.goforcode.s3example.controllers;

import java.io.File;
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
		private String origin = "https://s3-us-west-2.amazonaws.com/goforcode-oct2017-communityshade/";

		public ToolController(ToolRepo toolRepo) {
			this.toolRepo = toolRepo;
		}

		@GetMapping("")
//		public List<Tool> getAll() {
//			return toolRepo.findAll();
		public ModelAndView showDefault() {
		System.out.println("ToolController: listall");
		ModelAndView mv = new ModelAndView("home/list");
		mv.addObject("tools", toolRepo.findAll());
		return mv;
		}
		
		@GetMapping("/{id}")
		public Tool getOneTool(@PathVariable long id) {
			System.out.println("ToolController: id: " + id);
			return toolRepo.findOne(id);
		}

		@PostMapping("new")
//		Create some annotation to bring a file
//		public Tool createTool(@RequestBody Tool tool) {
		
		public String createTool(String toolName, String toolDescription, String image, File file) {
			System.out.println("ToolController: New : " + toolName + " " + file);
			Tool tool = new Tool(toolName, toolDescription, origin + file.getName());
			toolRepo.save(tool);
			return "redirect:/tools";
		}
		
		@PutMapping("{id}")
		public Tool updateTool(@RequestBody Tool tool, @PathVariable long id) {
			tool.setId(id);
			System.out.println("ToolController: update " + id);
			return toolRepo.save(tool);
		}
	
}

