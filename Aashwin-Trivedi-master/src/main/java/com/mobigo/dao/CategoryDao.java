package com.mobigo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobigo.model.AddCategory;

@Repository
public class CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveAddCategory(AddCategory add)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(add);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List listCat()
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		List category = session.createQuery("FROM AddCategory").list(); 
		
		session.getTransaction().commit();
		session.close();
		
		return category;
		
	}
	
	public AddCategory getCat(int catid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		AddCategory cat = (AddCategory)session.get(AddCategory.class,catid); 
		
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println(cat.getCname());
		System.out.println("=============================="+cat.getCid());
		return cat;
	}
	
	
	public void updateCat(AddCategory catobj)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		session.saveOrUpdate(catobj); 
		
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println(catobj.getCname());
		System.out.println("=============================="+ catobj.getCid());
		
	}

	public AddCategory deleteCat(int id)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		AddCategory adc= (AddCategory)session.get(AddCategory.class,id);
		session.delete(adc);
		session.getTransaction().commit();
		session.close();
		
		return adc;
	}
}