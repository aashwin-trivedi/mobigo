package com.mobigo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobigo.dao.CartDao;
import com.mobigo.dao.ProdDao;
import com.mobigo.model.Cart;
import com.mobigo.model.Prod;
import com.mobigo.model.UserDetails;

@Controller
public class CartController {
	int crtcnt=0;
	double tot=0;
	@Autowired
	CartDao crtDao;
	
	@Autowired
	ProdDao pdao;
	
	@RequestMapping(value="/AddtoCart",method=RequestMethod.GET)
	public String adCart(@RequestParam ("prid")int pid,@RequestParam ("q")int qty,HttpSession session,Map<String,Object> model)
	{
		crtcnt++;
		session.setAttribute("cnt",crtcnt);
		Prod p=pdao.getP(pid);
		Cart c=new Cart();
		int x=crtDao.maxId();
		c.setCartid(++x);
		
		c.setCartuser((String)session.getAttribute("UserName"));
		c.setProductid(p.getId());
		c.setProdname(p.getName());
		c.setProdprice(p.getPrice());
		c.setQuantity(qty);
		c.setCarttotal(p.getPrice()*qty );
		tot=tot+p.getPrice()*qty;
		session.setAttribute("crtTot",tot);
		crtDao.saveCart(c);
		
		List clist=crtDao.listCart((String)session.getAttribute("UserName"));
		model.put("crt", clist);
				
		return "ShowCart";
		
	}
	
	@RequestMapping(value="/removecart",method=RequestMethod.GET)
	public String RemoveCart(@RequestParam("crd")int crdd,HttpSession session,Map <String,Object> model)
	{
		crtDao.removeCart(crdd);
		
		List clist=crtDao.listCart((String)session.getAttribute("UserName"));
		model.put("crt", clist);
				
		return "ShowCart";
		
	}
	
	@RequestMapping(value="/showCart",method=RequestMethod.GET)
	public String showCart(HttpSession session,Map <String,Object> model)
	{

		List clist=crtDao.listCart((String)session.getAttribute("UserName"));
		model.put("crt", clist);
				
		return "ShowCart";
		
	}
	
	
	@RequestMapping(value = "/OrderConfirm", method = RequestMethod.GET)
	public String orderConfirm( HttpSession session,Model m) {

		
		String usernam=(String)session.getAttribute("userId");
		List<UserDetails> userData=crtDao.getUser(usernam);
		if(userData!=null)
		{
		
			UserDetails ud=userData.get(0);
			System.out.println("pro idddd" + ud.getUserName());
		m.addAttribute("UserInfo",userData);
		
		
		}
            return "OrderConfirm";
	}
	
	
	
	@RequestMapping(value = "/Payment", method = RequestMethod.GET)
	public String gotoPayment( ) {

		   return "Payment";
	}
	
	
	
	@RequestMapping(value = "/ThankYou", method = RequestMethod.GET)
	public String removeCart( HttpSession session,Model m) {

		System.out.println("hello11");
		String cu=(String)session.getAttribute("userId");
		
		 crtDao.removeCartUser(cu);
		 
            return "ThankYou";
	}
	
}
