package com.carloan.finance.app.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloan.finance.app.enums.LoanStatus;
import com.carloan.finance.app.model.Customer;
import com.carloan.finance.app.model.LoanDisbursement;
import com.carloan.finance.app.repository.CustomerRepository;
import com.carloan.finance.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private  CustomerRepository customerRepository;
	
	@Override
	public Customer findByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LoanDisbursement loanDisbursedCustomer(int customerId) {
		
		Customer customer = customerRepository.findByCustomerId(customerId);		
		LoanDisbursement loanDisbursement=new LoanDisbursement();
		loanDisbursement.setDisbursedmentId(customer.getCustomerId());
		loanDisbursement.setCustomerName(customer.getCustomerName());
		loanDisbursement.setAccountNumber(customer.getAccountDetails().getAccountNumber());
		loanDisbursement.setBankName(customer.getAccountDetails().getBankName());
		loanDisbursement.setIfscCode(customer.getAccountDetails().getIfscCode());
		loanDisbursement.setAccountType(customer.getAccountDetails().getAccountType());
		
		loanDisbursement.setAgrrementId(new Random().nextInt(10000)+90000);
		loanDisbursement.setAgreementDate(Date.valueOf(LocalDate.now()));
		loanDisbursement.setAmountPaidDate(Date.valueOf(LocalDate.now()));
		
		
		loanDisbursement.setLoanNo(new Random().nextInt(100000)+900000);
		loanDisbursement.setAmountPayTye("online");
		
		
		loanDisbursement.setPaymentStatus("paid");
		loanDisbursement.setTotalAmount(customer.getSanctionLetter().getLoanAmtSanctioned());
		loanDisbursement.setTotalAmountWithInterest(customer.getSanctionLetter().getTotalAmountWithInterest());
		loanDisbursement.setTransferAmount(customer.getSanctionLetter().getLoanAmtSanctioned());
		
		customer.setDisbursement(loanDisbursement);
		
		customerRepository.save(customer);
		return loanDisbursement;
	}
	

	@Override
	public Customer findByLoanStatus(LoanStatus loanstatus) {
		
		//Customer customer = customerRepository.findByloanStatus(loanstatus);
		List<Customer> customers1=customerRepository.findByloanStatus(loanstatus);
		Customer c=null;
		for (Customer customer : customers1) {
			
			LoanDisbursement loanDisbursement=new LoanDisbursement();
			loanDisbursement.setDisbursedmentId(customer.getCustomerId());
			loanDisbursement.setAccountNumber(customer.getAccountDetails().getAccountNumber());
			loanDisbursement.setBankName(customer.getAccountDetails().getBankName());
			loanDisbursement.setIfscCode(customer.getAccountDetails().getIfscCode());
			loanDisbursement.setAccountType(customer.getAccountDetails().getAccountType());
			
			loanDisbursement.setAgrrementId(new Random().nextInt(10000)+90000);
			loanDisbursement.setAgreementDate(Date.valueOf(LocalDate.now()));
			loanDisbursement.setAmountPaidDate(Date.valueOf(LocalDate.now()));
			
			
			loanDisbursement.setLoanNo(new Random().nextInt(100000)+900000);
			loanDisbursement.setAmountPayTye("online");
			
			
			loanDisbursement.setPaymentStatus("paid");
			loanDisbursement.setTotalAmount(customer.getSanctionLetter().getLoanAmtSanctioned());
			loanDisbursement.setTransferAmount(customer.getSanctionLetter().getLoanAmtSanctioned());
			
			customer.setDisbursement(loanDisbursement);
			
			customerRepository.save(customer);
			c=customer;
			
		}
		
		
		return c;
	
	}



//	@Override
//	public List<Customer> getLoanAcceptedCustomer(LoanStatus loanstatus) {
//	
//		List<Customer> customer=customerRepository.findByloanStatus(loanstatus);
//		return customer;
//	}

	@Override
	public List<Customer> getAllLoanAcceptedCustomer(LoanStatus loanstatus) {
	
		List<Customer> customer=customerRepository.findByloanStatus(loanstatus);
		List<Customer> cosList=new ArrayList<Customer>();
		
	for (Customer customer2 : customer) {
		Customer customer3=new Customer();
		customer3.setCustomerName(customer2.getCustomerName());
		customer3.setCustomerId(customer2.getCustomerId());
		customer3.setCustomerEmail(customer2.getCustomerEmail());
		cosList.add(customer3);
		
	}
		return cosList;
	}

	@Override
	public List<Customer> getLoanRejectedCustomer(LoanStatus loanstatus) {
		List<Customer> customer=customerRepository.findByloanStatus(loanstatus);
		
		return customer;
	}



	

	

	

}
