package com.webbertech.web.controller;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.webbertech.web.configuration.AppConfig;
import com.webbertech.web.dao.EmployeeDao;
import com.webbertech.web.model.Employee;
import com.webbertech.web.service.EmployeeService;
import org.joda.time.LocalDate;

@Controller
public class EmployeeController {

	/*TODO refactor this and write something better to get the context and persist it
	 * don't not load the xml file everything you need it
	 * 
	 * To test this, you need postman client in chrome, and test if it gets http 200 and 
	 * write to db
	 * 
	 * For writting record, use json, and get json using @RequestBody
	 * */
	@RequestMapping(value="/employee/add", method=RequestMethod.POST)
	public ModelAndView insertEmployee(HttpServletRequest request,
			HttpServletResponse response)  {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		Employee e1 = new Employee();
		e1.setId(147);
		e1.setFirstName("xiaofeng");
		e1.setLastName("li");
		e1.setJoiningDate(new org.joda.time.LocalDate(2010,10,10));
		e1.setSalary(new BigDecimal(20000));
		e1.setSsn("ssn00000002");
		service.saveEmployee(e1);
		
		Employee e2 = new Employee();
		e2.setId(148);
		e2.setFirstName("xiaofeng");
		e2.setLastName("li");
		e2.setJoiningDate(new LocalDate(2012,11,11));
		e2.setSalary(new BigDecimal(20000));
		e2.setSsn("ssn00000002");
		service.saveEmployee(e2);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		context.close();
		return mv;
	}
}
