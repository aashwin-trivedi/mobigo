package com.mobigo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mobigo.dao.InsertDao;
import com.mobigo.model.UserCredential;
import com.mobigo.model.UserDetails;

@Controller
@RequestMapping(value = "/Register")
public class RegisterController {
	
	@Autowired
	   InsertDao indao;
	
 @RequestMapping(method = RequestMethod.GET)
 public ModelAndView viewRegistration() 
 {
  ModelAndView mv=new ModelAndView("Register","command",new UserDetails());
  return mv;
 }
  
 @RequestMapping(method = RequestMethod.POST)
 public String processRegistration(@Valid @ModelAttribute("UserDetails")UserDetails reg,BindingResult result,Map<String, Object> model) {
      
	 if (result.hasErrors()) 
	     {
		 return "Register";
         }

	 
	 
	 // implement your own registration logic here...
      
     // for testing purpose:
     System.out.println("username: " + reg.getName());
     System.out.println("password: " + reg.getPassword());
    // System.out.println("email: " + user.getEmail());
    
     UserCredential uc=new UserCredential();
     uc.setUserName(reg.getUserName());
     uc.setPassword(reg.getPassword());
     uc.setEnabled(true);
     uc.setRole("ROLE_USER");
     indao.insertData(reg);
     indao.insertLogin(uc);
      
     return "insertSuccess";
 }
	

}
