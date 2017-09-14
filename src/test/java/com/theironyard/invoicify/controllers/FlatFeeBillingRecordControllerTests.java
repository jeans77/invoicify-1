package com.theironyard.invoicify.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.Company;
import com.theironyard.invoicify.models.FlatFeeBillingRecord;
import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.BillingRecordRepository;
import com.theironyard.invoicify.repositories.CompanyRepository;

public class FlatFeeBillingRecordControllerTests {
	
	private FlatFeeBillingRecordController controller;
	private BillingRecordRepository repo;
	private CompanyRepository companyRepo;
	
	@Before
	public void setup() {
		repo = mock(BillingRecordRepository.class);
		companyRepo = mock(CompanyRepository.class);
		controller = new FlatFeeBillingRecordController(repo, companyRepo);
	}


//	BillingRecordRepository records = mock(BillingRecordRepository.class);
//	CompanyRepository companies = mock(CompanyRepository.class);
//	Authentication auth = mock(Authentication.class);
//	FlatFeeBillingRecord record = new FlatFeeBillingRecord();
//	User user = new User();
//	Company company = new Company();
//	when(auth.getPrincipal()).thenReturn(user);
//	when(companies.findOne(3l)).thenReturn(company);
//	FlatFeeBillingRecordController controller = new FlatFeeBillingRecordController(records, companies);
//
//	ModelAndView actual = controller.create(record,  3l, auth);
//
//	verify(auth).getPrincipal();
//	verify(companies).findOne(3l);
//	assertThat(record.getClient()).isSameAs(company);
//	assertThat(record.getCreatedBy()).isSameAs(user);
//	verify(records).save(record);
//	assertThat(actual.getViewName()).isEqualTo("redirect:/billing-records");
	
}
