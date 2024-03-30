package com.spring.empDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.springbank.entities.Employee;

public class EmpDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	public int change(Employee emp) {
		// TODO Auto-generated method stub
		//updating the data hehehe
		String query="update bank set Amount=? where pin_number=?";
			int r=	this.jdbcTemplate.update(query,emp.getAmount(),emp.getPinNum());
		return r;
	}
	
	
	
	
	public Employee getEmployee(int pin_number) {
		String query="select * from bank where pin_number=?";
		RowMapper <Employee> rowMapper=new RowMapperImpl();
		Employee emp=this.jdbcTemplate.queryForObject(query, rowMapper,pin_number);
		
		return emp;
		
	}
	


public int insert(Employee emp) {
	String query = "insert into bank values(?,?,?)";
	int r=this.jdbcTemplate.update(query,emp.getPinNum(),emp.getName(),emp.getAmount());
	return r;
	
	
}
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}

