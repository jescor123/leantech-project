package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees(String search) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(search == null) {	
			
			String queryString = "from Employee order by salary desc";
			Query<Employee> theQuery = 
					currentSession.createQuery(queryString, Employee.class);
			List<Employee> employees = theQuery.getResultList();
			return employees;
			
		} else {
			
			String queryString = "from Employee where lower(name) like :theSearch or lower(positiondesc) like :theSearch order by salary desc";
			Query<Employee> theQuery = 
					currentSession.createQuery(queryString, Employee.class);
			theQuery.setParameter("theSearch", "%" + search.toLowerCase() + "%");
			List<Employee> employees = theQuery.getResultList();
			return employees;
			
		}
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
        		
	}

	@Override
	public void deleteEmployee(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Employee> getEmployeesByPosition(int position) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Employee where position=:PositionId order by salary desc";
		Query<Employee> theQuery = 
				currentSession.createQuery(queryString, Employee.class);
		theQuery.setParameter("PositionId", position);
		List<Employee> employees = theQuery.getResultList();
		return employees;
		
	}

	
}
