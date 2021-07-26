package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Position;


@Repository
public class PositionDAOImpl implements PositionDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Position> getPositions() {
		
		        // get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// create a query  
				String queryString = "from Position";
				Query<Position> theQuery = 
						currentSession.createQuery(queryString, Position.class);
				
				// execute query and get result list
				List<Position> customers = theQuery.getResultList();
						
				// return the results		
				return customers;
		
	}

	
}