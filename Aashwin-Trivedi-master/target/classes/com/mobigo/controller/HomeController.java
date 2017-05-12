package com.mobigo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	
@RequestMapping("/aboutus")
public String aboutus()
{
	return "aboutus";
}
@RequestMapping("/contactus")
public String contactus()
{
	return "contactus";
}
@RequestMapping("/home")
public String home()
{
	return "home";
}
@RequestMapping("/login")
public String login()
{
	return "login";
}
@RequestMapping("/products")
public String products()
{
	return "products";
}
@RequestMapping("/register")
public String register()
{
	return "register";
}
}
