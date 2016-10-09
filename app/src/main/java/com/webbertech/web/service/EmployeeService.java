package com.webbertech.web.service;

import java.util.List;
import com.webbertech.web.model.Employee;

public interface EmployeeService {
	Employee findEmployeeById(int id);
	boolean isEmployeeSsnUnique(Integer id, String ssn);
	void saveEmployee(Employee employee);
	void updateEmployee(Employee employee);
	List<Employee> findAllEmployees();
	void deleteEmployeeBySsn(String ssn);
	Employee findEmployeeBySsn(String ssn);
}