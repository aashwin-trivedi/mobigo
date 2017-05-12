package com.mobigo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobigo.dao.SuppDao;
import com.mobigo.model.Supplier;

@Controller

public class SuppController {
	
	
	@Autowired
	SuppDao supDAO;

	@RequestMapping (value="/Supplier",method=RequestMethod.GET)
	public String viewSupplier( Map <String,Object> model){	
	Supplier addSupp=new Supplier();
	model.put ("addSupp", addSupp);
	
	List sup=supDAO.listSupp();
	model.put("suplist",sup);
	model.put("spedit",0);
	return "Supplier";
}
	@RequestMapping (value="/Supplier",method=RequestMethod.POST)
	public String processSupplier (@ModelAttribute("addSupp") Supplier supp,
			Map <String,Object> model){
		
		System.out.println("Supplier ID :" + supp.getSid());
		System.out.println("Supplier Name :" + supp.getSname());
		System.out.println("Description :" + supp.getSdescription());
		
		supDAO.storeSupplier(supp);
		
		List sup=supDAO.listSupp();
		model.put("suplist", sup);
		model.put("spedit",0);
		return "Supplier";
	}
	
	@RequestMapping(value="/EditS",method=RequestMethod.GET)
	public String eSupplier(@RequestParam("supid") int sid, Map <String,Object> model)
	{
		Supplier splr=supDAO.getSup(sid);
		System.out.println("getting id" + splr.getSid());
		System.out.println("getting name" + splr.getSname());
		System.out.println("getting description " + splr.getSdescription());
		
		List <Supplier> sl=new ArrayList<Supplier>();
		sl.add(splr);
		model.put("addSupp", sl);
		model.put("supData",splr);
		model.put("spedit", 1);
		
		List sup=supDAO.listSupp();
		model.put("suplist",sup);
		
		return "Supplier";
		
	}
		
	@RequestMapping (value="/editsupplier",method=RequestMethod.POST)
	public String editSupplier(@ModelAttribute("addSupp") Supplier supp,
			Map <String,Object> model){
		
		System.out.println("Supplier ID :" + supp.getSid());
		System.out.println("Supplier Name :" + supp.getSname());
		System.out.println("Description :" + supp.getSdescription());
		
		model.put("spedit",0);
		supDAO.updateSupplier(supp);
		
		List sup=supDAO.listSupp();
		model.put("suplist" , sup);
		
		return "Supplier";
		
	}
	
	@RequestMapping (value="/delsup",method=RequestMethod.GET)
	public String delSup(@RequestParam ("suid")int s, Map <String,Object> model)
	{
		model.put("spedit",0);
		supDAO.delSupplier(s);
		
		List sup=supDAO.listSupp();
		model.put("suplist", sup);
		
		return "Supplier";
	}
}
