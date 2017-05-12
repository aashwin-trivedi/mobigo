package com.mobigo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobigo.model.AddCategory;
import com.mobigo.model.Prod;

@Repository
public class ProdDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProd(Prod prod)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		session.save(prod);
		session.getTransaction().commit();
		session.close();
	}
	
	public List listPro()
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		
		List products=session.createQuery("FROM Prod").list();
		
		session.getTransaction().commit();
		session.close();
		
		return products;
	}
	
	public Prod getP(int proid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		Prod pro = (Prod)session.get(Prod.class,proid); 
		
		session.getTransaction().commit();
		session.close();
		return pro;
	}
	
	
	public void updateProd(Prod pr)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		session.saveOrUpdate(pr); 
		
		session.getTransaction().commit();
		session.close();
	}
	
	public Prod deleteProd(int prid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		Prod p = (Prod)session.get(Prod.class,prid);
		
		session.delete(p);
		session.getTransaction().commit();
		session.close();
		return p;
				
	}
}
