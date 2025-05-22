package com.carloan.finance.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.carloan.finance.app.enums.LoanStatus;
import com.carloan.finance.app.model.Customer;
import com.carloan.finance.app.model.LoanDisbursement;
import com.carloan.finance.app.service.CustomerService;
@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	private  CustomerService customerService;
	
	@GetMapping("/loandisbursed/{customerId}")
	public ResponseEntity<LoanDisbursement> loanDisbursedCustomer(@PathVariable("customerId")int customerId)
	{
		LoanDisbursement disbursement=customerService.loanDisbursedCustomer(customerId);
		return new ResponseEntity<LoanDisbursement>(disbursement,HttpStatus.OK);
	}
	
	
	
//	@GetMapping("/getloan_accepted_customer/{loanstatus}")
//	public ResponseEntity< List<Customer>> getLoanAcceptedCustomer(@PathVariable("loanstatus")LoanStatus loanstatus)
//	{
//		 List<Customer> loanAcceptedCustomer = customerService.getLoanAcceptedCustomer(loanstatus);
//		return new ResponseEntity< List<Customer>>(loanAcceptedCustomer,HttpStatus.OK);
//		
//	}
	
	@GetMapping("/getloan_All_accepted_customer/{loanstatus}")
	public ResponseEntity<List<Customer>> geAlltLoanAcceptedCustomer(@PathVariable("loanstatus")LoanStatus loanStatus)
	{
		List<Customer> customer=customerService.getAllLoanAcceptedCustomer(loanStatus);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
		
	}
	
	@GetMapping("/getloan_rejected_customer/{loanstatus}")
	public ResponseEntity<List<Customer>> getLoanRejectedCustomer(@PathVariable("loanstatus")LoanStatus loanstatus)
	{
		List<Customer> loanRejectedCustomer = customerService.getLoanRejectedCustomer(loanstatus);
		return new ResponseEntity<List<Customer>>(loanRejectedCustomer,HttpStatus.OK);
		
	}
	
	
	

	
	
}
