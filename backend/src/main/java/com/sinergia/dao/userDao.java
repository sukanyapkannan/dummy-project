package com.sinergia.dao;

import com.sinergia.model.User;

public interface userDao
{
	 boolean saveUser(User u);

	User getUserbyemail(String emaill);
	User getUser(int id);
	public User getUserbyId(int userId);
}
