package com.libertymutual.goforcode.s3example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.s3example.models.Tool;
import com.libertymutual.goforcode.s3example.repositories.ToolRepo;

	@RestController
	@RequestMapping("/api/tools")
	@CrossOrigin(origins = "*")
	public class ToolController {

		private ToolRepo toolRepo;

		public ToolController(ToolRepo toolRepo) {
			this.toolRepo = toolRepo;

		}

		@GetMapping("")
		public List<Tool>  getAll() {
			return toolRepo.findAll();
		}

		@GetMapping("{id}")
		public Tool getOneTool(@PathVariable long id) {
			return toolRepo.findOne(id);
		}

		@PostMapping("")
		public Tool createTool(@RequestBody Tool tool) {
			return toolRepo.save(tool);
		}
		
		@PutMapping("{id}")
		public Tool updateTool(@RequestBody Tool tool, @PathVariable long id) {
			tool.setId(id);
			return toolRepo.save(tool);
		}
	
}

