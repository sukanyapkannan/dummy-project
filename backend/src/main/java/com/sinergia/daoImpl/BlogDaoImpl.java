package com.sinergia.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinergia.dao.BlogDao;
import com.sinergia.model.Blog;

public class BlogDaoImpl implements BlogDao 
{
	@Autowired
	private SessionFactory sessionF;
	public BlogDaoImpl(SessionFactory sessionF)
	{
		super();
		this.sessionF=sessionF;
	}
	public BlogDaoImpl()
	{
		super();
		
	}
	@Override
	public boolean addBlog(Blog blog)
	{
		try
		{
			Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(blog);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
