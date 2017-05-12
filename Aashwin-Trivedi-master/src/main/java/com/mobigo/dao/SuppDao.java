package com.mobigo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobigo.model.Supplier;

@Repository
public class SuppDao {
	
	@Autowired
	 SessionFactory sessionFactory;
	
	
	public void storeSupplier(Supplier supp)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(supp);
		session.getTransaction().commit();
			session.close();
	}
	
	public List listSupp()
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		List suppliers=session.createQuery("FROM Supplier").list();
		
		session.getTransaction().commit();
		session.close();
		
		return suppliers;
	}
	
	public Supplier getSup (int supid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		
		Supplier su=(Supplier)session.get(Supplier.class,supid);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(su.getSname());
		System.out.println(su.getSid());
		System.out.println(su.getSdescription());
		
		return su;
	}

	public void updateSupplier(Supplier supplier)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		
		session.saveOrUpdate(supplier);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(supplier.getSname());
		System.out.println(supplier.getSid());
		System.out.println(supplier.getSdescription());
		}

	public Supplier delSupplier(int suid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		Supplier s=(Supplier)session.get(Supplier.class,suid);
		
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
		return s;
				
	}
}
