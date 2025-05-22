package com.carloan.finance.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.carloan.finance.app.enums.LoanStatus;
import com.carloan.finance.app.model.Customer;
import com.carloan.finance.app.model.Enquiry;
import com.carloan.finance.app.model.LoanDisbursement;
import com.carloan.finance.app.model.LocalAddress;

public interface CustomerService {
	
	
	
	public Customer findByCustomerId(int customerId);

	public Customer findByLoanStatus(LoanStatus loanstatus);

	public List<Customer> getLoanRejectedCustomer(LoanStatus loanstatus);

	//public List<Customer> getLoanAcceptedCustomer(LoanStatus loanstatus);

	public List<Customer> getAllLoanAcceptedCustomer(LoanStatus loanStatus);

	public LoanDisbursement loanDisbursedCustomer(int customerId);
	
}
