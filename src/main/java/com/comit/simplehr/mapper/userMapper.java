package com.comit.simplehr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.comit.simplehr.bean.UserBean;

public class userMapper implements RowMapper<UserBean> {

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean user=new UserBean();
		user.setIdUser(rs.getInt("ID_USER"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setBirth(rs.getDate("BIRTH"));
		user.setStatus(rs.getString("STATUS"));
		
		return user;
	
	}
	

}
