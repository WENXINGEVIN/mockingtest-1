package com.webbertech.web.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
   
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
   public String adminPage(ModelMap model) {
       model.addAttribute("user", getPrincipal());
       return "admin";
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
    
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
    
    /**
     * This is not working yet.
     * @return
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "admin";
    }
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        /*if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {*/
            userName = principal.toString();
       // }
        return userName;
    }
}