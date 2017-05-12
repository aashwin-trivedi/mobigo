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

import com.mobigo.dao.CategoryDao;
import com.mobigo.model.AddCategory;

@Controller
public class CatController {
	
	@Autowired
	CategoryDao catDao;
	
	@RequestMapping (value="/Category",method=RequestMethod.GET)
	public String viewCategory(Map <String,Object> model) {
		AddCategory addCat=new AddCategory();
		model.put("addCat",addCat);
		
		List cat=catDao.listCat();
		model.put("catlist",cat);
		model.put("editing",0);
		return "Category";
	}

	@RequestMapping (value="/Category",method=RequestMethod.POST)
	public String processCategory(@ModelAttribute("addCat") AddCategory add,Map <String,Object> model) {
		
	   System.out.println("Category ID :" + add.getCid());
	   System.out.println("Name :" + add.getCname());
	   System.out.println("Description :" + add.getCatdes());
	   
	   catDao.saveAddCategory(add);
	   
	   
		
		List cat=catDao.listCat();
		model.put("catlist",cat);
		 model.put("editing",0);
	   
	   return "Category";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editCat(@RequestParam("catid")int cid,Map <String,Object> model)
	{
		
		AddCategory ac=catDao.getCat(cid);
		System.out.println("===================="+ac.getCid());
		System.out.println("===================="+ac.getCname());
        List<AddCategory> catl=new ArrayList<AddCategory>();
        catl.add(ac);
		model.put("addCat",catl);
		model.put("catData",ac);
		model.put("editing",1);
		
		
		List cat=catDao.listCat();
		model.put("catlist",cat);
		
		return "Category";
	}
	
	@RequestMapping (value="/editCategory",method=RequestMethod.POST)
	public String editCategory(@ModelAttribute("addCat") AddCategory add,Map <String,Object> model) {
		
	   System.out.println("Category ID :" + add.getCid());
	   System.out.println("Name :" + add.getCname());
	   System.out.println("Description :" + add.getCatdes());
	   model.put("editing",0);
	   catDao.updateCat(add);
	   
	   
		
		List cat=catDao.listCat();
		model.put("catlist",cat);
	   
	   return "Category";
	}
 
	@RequestMapping(value="/deletecat",method=RequestMethod.GET)
	public String DeleteCat(@RequestParam("id")int i,Map <String,Object> model)
	{
		model.put("editing",0);
		catDao.deleteCat(i);
		List cat=catDao.listCat();
		model.put("catlist",cat);
		
		
		return "Category";
	}
}