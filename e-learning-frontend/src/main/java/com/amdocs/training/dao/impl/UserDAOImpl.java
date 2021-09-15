package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amdocs.training.config.DBUtil;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.model.User;

public class UserDAOImpl implements UserDAO {

	Connection conn = DBUtil.getConnection();

	public boolean saveUser(User user) {
		String sql = "insert into user (username, password, phoneNumber) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getPhoneNumber());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
