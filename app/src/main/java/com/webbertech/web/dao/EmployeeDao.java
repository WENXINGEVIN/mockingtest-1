package com.webbertech.web.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.webbertech.web.model.Employee;

public class EmployeeDao {
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
		template.setCheckWriteOperations(false);
	}

	@Transactional(readOnly = false)
	public void saveEmployee(Employee e) {
		template.save(e);
	}

	@Transactional(readOnly = false)
	public void updateEmployee(Employee e) {
		template.update(e);
	}

	@Transactional(readOnly = false)
	public void deleteEmployee(Employee e) {
		template.delete(e);
	}
}