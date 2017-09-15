package com.theironyard.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theironyard.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
//	List<BillingRecord> findByClientId(long clientId);
	//this will generate a SQL query to fetch Billing Records of a client, 
	// then join with Company  to find the Company Id
	
	List<BillingRecord> findByIdIn(long[] recordIds);
	List<BillingRecord> findByClientIdAndLineItemIsNull(long clientId);
}