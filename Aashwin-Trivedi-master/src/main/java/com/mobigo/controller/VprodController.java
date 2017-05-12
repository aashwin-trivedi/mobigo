package com.mobigo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mobigo.dao.ViewpDao;
import com.mobigo.model.Prod;


@Controller
public class VprodController {

	@Autowired
	ViewpDao vDao;
	
	@RequestMapping (value="/ViewProd",method=RequestMethod.GET)
	public String viewAddProduct(Map <String , Object > model){
		Prod addProd=new Prod();
		model.put("addProd", addProd);
		
		List prolist=vDao.listPro();
		model.put("pro",prolist);
		model.put("ed", 0);
		return "ViewProd";
	}
	
	@RequestMapping (value="/ViewProd",method=RequestMethod.POST)
	public String processAddProduct (@ModelAttribute("addProd")Prod prod, Map <String,Object> model){
		
		System.out.println("Product ID :" + prod.getId());
		System.out.println("Product Name :" + prod.getName());
		System.out.println("Description :" + prod.getDescription());
		System.out.println("Quantity :" +prod.getQuantity());
		System.out.println("Price :" + prod.getPrice());
		System.out.println("Manufacturing Date :" +prod.getMfg());
		
		vDao.saveProd(prod);
		
		List prolist=vDao.listPro();
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
		return "ViewProd";
		}	
	
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String infoProduct(@RequestParam("pid")int pid,Map <String,Object> model)
	{
		
		Prod product=vDao.infoPro(pid);
		System.out.println(product.getId());
		
        List <Prod> pl=new ArrayList<Prod>();
        
        pl.add(product);
        
		model.put("addProd",pl);
		
		List prolist=vDao.listPro();
		model.put("pro", prolist);
		
		return "Info";
	}
}
