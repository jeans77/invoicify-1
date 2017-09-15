package com.theironyard.invoicify.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.Company;
import com.theironyard.invoicify.models.Invoice;
import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.CompanyRepository;

@Controller
@RequestMapping("/companies")
public class CompanyController {
	

	@Autowired
	private CompanyRepository companyRepository;
		
	@PostMapping("create")
	public String createCompany(Company company, String name, Authentication auth) {
		User creator = (User) auth.getPrincipal();
		company.setName(name);
		companyRepository.save(company);		
		return "redirect:/companies";
	}
	
	@GetMapping("")
	public ModelAndView list(Authentication auth) {
		User user = (User) auth.getPrincipal();

		ModelAndView mv = new ModelAndView("companies/admin");
		List<Company> companies = companyRepository.findAll();
		
		mv.addObject("showTable", companies.size() > 0);
		mv.addObject("companies", companyRepository.findAll(new Sort(Sort.Direction.ASC, "name")));
		return mv;
	}
	
}
