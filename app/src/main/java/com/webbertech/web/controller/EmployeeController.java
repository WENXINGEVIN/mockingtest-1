package com.webbertech.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.webbertech.web.dao.EmployeeDao;
import com.webbertech.web.model.Employee;

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
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-datasource.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
		Employee e = new Employee();
		e.setId(147);
		e.setName("kumar");
		e.setSalary(70000);
		 dao.saveEmployee(e);
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("index");
		return mv;
	}
}
