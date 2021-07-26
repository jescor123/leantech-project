package com.luv2code.springdemo.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Person;



@Repository
public class PersonDAOImpl implements PersonDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Person getPerson(int id) {
				        	
		Session currentSession = sessionFactory.getCurrentSession();
        Person person = currentSession.get(Person.class, id);
		return person;
		
	}

	
}
