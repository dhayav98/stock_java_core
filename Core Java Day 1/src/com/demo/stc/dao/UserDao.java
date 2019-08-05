package com.demo.stc.dao;

import java.sql.SQLException;

import com.demo.stc.model.Company;
import com.demo.stc.model.User;

public interface UserDao {
	public User insertUser(User user) throws ClassNotFoundException, SQLException;

	public User updateUser(User user) throws ClassNotFoundException, SQLException;
}
