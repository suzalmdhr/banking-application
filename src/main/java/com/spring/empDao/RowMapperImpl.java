package com.spring.empDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbank.entities.*;

public class RowMapperImpl implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Employee emp =new Employee();
		emp.setPinNum(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setAmount(rs.getInt(3));
		
		return emp;
	}
	
	

}
