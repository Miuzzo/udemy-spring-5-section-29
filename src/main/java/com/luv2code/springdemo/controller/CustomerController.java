package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")	//force to use GET operation
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("Customers",theCustomers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create new empty customer model
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("Customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		System.out.println(theCustomer.toString());
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		//get the customer from our service
		Customer theCustomer = customerService.getCustomers(theId);
		//set customer as a model attribute to pre-populate the form.
		theModel.addAttribute("Customer", theCustomer);	
		//send over to our form
		return "customer-form";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("CustomerId") Customer postedTheCustomer, Model theModel) {
		//get the customer from our service
		Customer theCustomer = customerService.getCustomers(postedTheCustomer.getId());
		//set customer as a model attribute to pre-populate the form.
		theModel.addAttribute("Customer", theCustomer);	
		//send over to our form
		return "customer-form";
	}
	
}
