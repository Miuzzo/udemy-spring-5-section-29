package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> cQuery = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = cQuery.getResultList();
		return customers;
	}

}
