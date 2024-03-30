package com.spring.empDao;

import com.springbank.entities.Employee;

public interface EmpDao {
	public int change(Employee emp);
	public int insert(Employee emp);
	public Employee getEmployee(int pin_number);

}
