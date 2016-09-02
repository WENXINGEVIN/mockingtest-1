package com.webbertech.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.webbertech.web.model.Contact;

@Controller
public class LandingPageController {

   @RequestMapping({"/", "/index"})  
	public ModelAndView index() {  
	        ModelAndView mv = new ModelAndView("index");
	        return mv;
	}
	
   @RequestMapping(value = "/login**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("login");
		return model;
	}
	
    @RequestMapping("/services")  
    public ModelAndView helloWorld() {  
        String message = "Services page";  
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", message);
        mv.setViewName("services");
        return mv;
    }
    
	@RequestMapping(value = {"/aboutus" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "AboutUs page");
		model.addObject("message", "This is welcome page!");
		model.setViewName("aboutus");
		return model;
	}
	
	//TODO this does not do much right now
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {  
        //write the code here to add contact  
        return "redirect:contact.html";  
    }  
      
    @RequestMapping("/contactus")  
    public ModelAndView showContacts() {  
        return new ModelAndView("contactus", "command", new Contact());  
    }
}