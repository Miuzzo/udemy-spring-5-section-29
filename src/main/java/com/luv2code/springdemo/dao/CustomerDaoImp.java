package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
//	@Transactional --> moved into service level
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		//add sort by lastName
		Query<Customer> cQuery = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = cQuery.getResultList();
		return customers;
	}
	
	public void saveCustomer(Customer customer) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//save new record
		session.save(customer);
	}

}
