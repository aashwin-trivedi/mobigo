package com.mobigo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mobigo.dao.ProdDao;
import com.mobigo.model.AddCategory;
import com.mobigo.model.Prod;

@Controller
public class ProdController {
	
	@Autowired
	ProdDao prodDao;
	
	@RequestMapping (value="/AddProd",method=RequestMethod.GET)
	public String viewAddProduct(Map <String , Object > model){
		Prod addProd=new Prod();
		model.put("addProd", addProd);
		
		List prolist=prodDao.listPro();
		model.put("pro",prolist);
		model.put("ed", 0);
		return "AddProd";
	}
	
	@RequestMapping (value="/AddProd",method=RequestMethod.POST)
	public String processAddProduct (@ModelAttribute("addProd")Prod prod, Map <String,Object> model){
		
		System.out.println("Product ID :" + prod.getId());
		System.out.println("Product Name :" + prod.getName());
		System.out.println("Description :" + prod.getDescription());
		System.out.println("Quantity :" +prod.getQuantity());
		System.out.println("Price :" + prod.getPrice());
		System.out.println("Manufacturing Date :" +prod.getMfg());
		
		prodDao.saveProd(prod);
		
		List prolist=prodDao.listPro();
		model.put("pro", prolist);
		model.put("ed", 0);
		
		try
		{
		String path="D:\\Project1\\Mobigo\\src\\main\\webapp\\resources\\";
		path=path+String.valueOf(prod.getId()) + ".jpg";
		File f=new File(path);
		MultipartFile filedata=prod.getImage();
		
		byte[] b=filedata.getBytes();
		FileOutputStream fos=new FileOutputStream(f);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		bos.write(b);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "AddProd";
		}	
	
	@RequestMapping(value="/editProduct",method=RequestMethod.GET)
	public String editProduct(@RequestParam("proid")int pi,Map <String,Object> model)
	{
		
		Prod product=prodDao.getP(pi);
		System.out.println(product.getId());
		
        List <Prod> pl=new ArrayList<Prod>();
        
        pl.add(product);
        
		model.put("addProd",pl);
		model.put("pData",product);
		model.put("ed",1);
		
		
		List prolist=prodDao.listPro();
		model.put("pro", prolist);
		
		return "AddProd";
	}
	
	@RequestMapping (value="/editP",method=RequestMethod.POST)
	public String editPr(@ModelAttribute("addProd")Prod prod, Map <String,Object> model){
		
		System.out.println("Product ID :" + prod.getId());
		System.out.println("Product Name :" + prod.getName());
		System.out.println("Description :" + prod.getDescription());
		System.out.println("Quantity :" +prod.getQuantity());
		System.out.println("Price :" + prod.getPrice());
		System.out.println("Manufacturing Date :" +prod.getMfg());
		
		prodDao.updateProd(prod);
		model.put("ed", 0);
		
		List prolist=prodDao.listPro();
		model.put("pro", prolist);
	   
	   return "AddProd";
	}
	
	@RequestMapping(value="/delpro",method=RequestMethod.GET)
	public String delProduct(@RequestParam("prid")int pd,Map <String,Object> model)
	{
	    model.put("ed", 0);
	    prodDao.deleteProd(pd);
	    
	    List prolist=prodDao.listPro();
		model.put("pro", prolist);
	   
	    return "AddProd";
	    
	}
}
