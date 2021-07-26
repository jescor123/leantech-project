package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.PersonDAO;
import com.luv2code.springdemo.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;
		
	@Override
	@Transactional
	public Person getPerson(int id) {
		
		return personDAO.getPerson(id);
		
	}
	
}
