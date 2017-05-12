package com.mobigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping ("/Register")
	public String regt()
	{
		return "Register";
	}
	@RequestMapping ("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping ("/abtus")
	public String ab()
	{
		return "abtus";
	}
	
	@RequestMapping ("/contact")
	public String con()
	{
		return "contact";
	}
	
	@RequestMapping ("/AddProd")
	public String addp()
	{
		return "AddProd";
	}
	
	
	@RequestMapping ("/ViewProd")
	public String viewPro()
	{
		return "ViewProd";
	}
	}
	

