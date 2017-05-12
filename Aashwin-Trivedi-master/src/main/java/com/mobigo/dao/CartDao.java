package com.mobigo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobigo.model.Cart;
import com.mobigo.model.UserDetails;
import org.hibernate.Transaction;
import org.hibernate.Query;

@Repository
public class CartDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Cart getCart(int prid)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method");
		session.beginTransaction();
		
		Cart crt=(Cart)session.get(Cart.class,prid);
		System.out.println(50);
		session.getTransaction().commit();
		session.close();
		return crt;
	}

	public void saveCart(Cart c)
	{
		Session session=sessionFactory.openSession();
		System.out.println(51);
		System.out.println("insert method");
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}
	
	public List listCart(String n)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		
		List cartlist=session.createQuery("FROM Cart where cartuser = '"+n+"'").list();
		
		session.getTransaction().commit();
		session.close();
		
		return cartlist;
	}
	
	public int maxId()
	{
	    Session session=sessionFactory.openSession();
		System.out.println("insert called method");
		session.beginTransaction();
		
		
		String SQL_QUERY = "select max(cartid) from Cart";
		List cartlist=session.createQuery(SQL_QUERY).list();
					
		session.getTransaction().commit();
		session.close();
		
		if(cartlist==null)
		{
		 System.out.println("if"+cartlist);
		 System.out.println(99);
			return 0;
		}
		else
		{
		System.out.println("else"+cartlist);
		System.out.println(95);
		    try {
		    	return (Integer) cartlist.get(0);	
		    }
		    catch(Exception e)
		    {
		    return 0;
		    }
		} 
	}
	
	public Cart removeCart(int crd)
	{
		Session session=sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		
		Cart rc = (Cart)session.get(Cart.class,crd);
		
		session.delete(rc);
		session.getTransaction().commit();
		session.close();
		return rc;	
	}
	
	public void removeCartUser(String crd)
	{
		
		String hql = "DELETE FROM Cart "  + 
	             "WHERE cartuser = :u_id";
	
		Session session=sessionFactory.openSession();
		System.out.println("clear cart method called"+crd);
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("u_id",crd);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Transactional
	public List<UserDetails> getUser(String id) {
		   
	    Session session=sessionFactory.openSession();    
	    Transaction t=session.beginTransaction();    
		String hql = "from"+" UserDetails "+" where userName=" +"'"+id+"'";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> listCategory = (List<UserDetails>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			
			
			return listCategory;
		}
		t.commit();    
		session.close();  
		
		return null;
	}

}