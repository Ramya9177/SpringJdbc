package com.zensar.training.service;

import java.sql.Connection;




import java.util.List;

import com.zensar.training.bean.Employee;
import com.zensar.training.db.DBConnectionFactory;
import com.zensar.training.db.EmployeeDAO;
import com.zensar.training.db.EmployeeSpringJdbcImpl;


public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public boolean addEmployee(Employee employee) throws Exception {
		boolean result=false;
		Connection connection=DBConnectionFactory.createConnection();
		connection.setAutoCommit(false);//records are told to not store instantly
		EmployeeDAO dao=new EmployeeSpringJdbcImpl();
		result = dao.addEmployee(connection, employee);
		if(result==true) {
			connection.commit();
			return result;
		}
		else
		{
			connection.rollback();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws Exception {
		boolean result=false;
		Connection connection=DBConnectionFactory.createConnection();
		EmployeeDAO dao=new EmployeeSpringJdbcImpl();
		result=dao.updateEmployee(connection, employee);
		return result;
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws Exception {
		boolean result=false;
		Connection connection=DBConnectionFactory.createConnection();
		EmployeeDAO dao=new EmployeeSpringJdbcImpl();
		result=dao.deleteEmployee(connection, employee);
		return result;
	}

	@Override
	public Employee findEmployee(int id) throws Exception {
		Connection connection=DBConnectionFactory.createConnection();
		EmployeeDAO dao=new EmployeeSpringJdbcImpl();
		Employee employee =dao.findEmployee(connection, id);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() throws Exception {
		Connection connection=DBConnectionFactory.createConnection();
		EmployeeDAO dao=new EmployeeSpringJdbcImpl();
		return dao.findAllEmployees();
		
	}

}
