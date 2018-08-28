package com.sinergia.daoImpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinergia.dao.userDao;
import com.sinergia.model.User;
@Repository("userDao")
public class UserDaoImpl implements userDao
{
	@Autowired
	private SessionFactory sessionF;
	
	
	public UserDaoImpl(SessionFactory sessionF) {
		super();
		this.sessionF = sessionF;
	}

	
	public UserDaoImpl() {
		super();
	}

	public boolean saveUser(User u) 
	{
		
		System.out.println("in saveUser"+u.getEmail());
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		return true;
	}


	@Override
	public User getUserbyemail(String emaill)
	{
		User user=new User();
		Session session= sessionF.openSession();
		Query query=session.createQuery("from User where email='"+emaill+"'");
		user=(User)query.list().get(0);
		session.close();
		return user;
	}


	
	public User getUser(int id)
	{
		Session k=sessionF.openSession();
		User c=(User)k.get(User.class, id);
		return c;
		
	}


	public User getUserbyId(int userId)
	{

		User user=new User();
		Session session= sessionF.openSession();
		Query query=session.createQuery("from User where userId='"+userId+"'");
		 user=(User)query.list().get(0);
		session.close();
		return user;
	}

}
