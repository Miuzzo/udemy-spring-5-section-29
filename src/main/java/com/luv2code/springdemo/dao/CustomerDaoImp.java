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
		///session.save(customer);
		//insert or update record
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int theId) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//now retrieve/read from database using the primary key
		Customer customer = session.get(Customer.class,theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(theId);
		Query deleteQuery = session.createQuery("delete from Customer where id=:customerId");
		deleteQuery.setParameter("customerId", theId);
		deleteQuery.executeUpdate();
	}

	@Override
	public List<Customer> getCustomers(String lastName) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> sQuery = null;
		if (!lastName.isEmpty() && lastName.trim().length() > 0) {
			sQuery = session.createQuery("from Customer where last_name like:lastName order by lastName", Customer.class);
			sQuery.setParameter("lastName", "%"+lastName+"%");
		} else {
			sQuery = session.createQuery("from Customer order by lastName", Customer.class);
		}
		List<Customer> customers = sQuery.getResultList();
		return customers;
	}

}
