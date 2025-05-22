package com.carloan.finance.app.serviceImpl;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloan.finance.app.model.Customer;
import com.carloan.finance.app.repository.CustomerRepository;
import com.carloan.finance.app.repository.EnquiryRepository;
import com.carloan.finance.app.repository.SanctionRepository;
import com.carloan.finance.app.service.SanctionService;

@Service
public class SanctionServiceImpl implements SanctionService {

	
	@Autowired
	private SanctionRepository  sanctionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public ByteArrayInputStream genrateSanctionletter(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getDocumentByIdAndType(int docid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

}
