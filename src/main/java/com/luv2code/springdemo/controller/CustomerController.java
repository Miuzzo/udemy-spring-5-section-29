package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerDao.getCustomers();
		theModel.addAttribute("Customers",theCustomers);
		return "list-customers";
	}

}
