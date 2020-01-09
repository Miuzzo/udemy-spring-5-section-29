package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//Insert business logic or other DAO retrieve
		return customerDao.getCustomers();
	}

}
