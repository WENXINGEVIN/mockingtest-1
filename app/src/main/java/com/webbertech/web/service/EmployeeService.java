package com.webbertech.web.service;

import java.util.List;
import com.webbertech.web.model.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);
}