package com.comit.simplehr.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.comit.simplehr.bean.UserBean;
import com.comit.simplehr.mapper.userMapper;
import com.comit.simplehr.util.Util;
import com.comit.simplehr.dao.*;

@Repository
public class SimplehrDao {

    List<UserBean> users;
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<UserBean> listUsers() {
		String sql="select * from user";
		
		return this.jdbcTemplate.query(sql,new userMapper());
	}
	
    public void createUser(UserBean user) {
		
		String sql = "INSERT INTO USER(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BIRTH, STATUS) "
			     + "VALUES(?,?,?,?,?,?)";
		
		
        this.jdbcTemplate.update(sql, user.getUsername(),user.getPassword(), user.getFirstName(), 
        		 user.getLastName(), user.getBirth(), "A");		        
	}
    public void updateUser(UserBean user) {
    	String sql = "UPDATE USER SET USERNAME = ?, FIRST_NAME = ?, "
				+ "LAST_NAME = ?, BIRTH = ? WHERE ID_USER = ?";
		
		int status = this.jdbcTemplate.update(sql, user.getUsername(),user.getFirstName(), user.getLastName(), 
				            user.getBirth(), user.getIdUser());
		
		if (status == 0) {
			logger.error("Error while updating user: ", user);
		}
	    	
    }
    
    public void deleteUser(int idUser) {
	     String sql = "DELETE FROM USER WHERE ID_USER = ?";
		
		int status = this.jdbcTemplate.update(sql, idUser);

		if (status == 0) {
		    logger.error("Error while deleting user, idUser: ", idUser);
		}
	
    	
    }
    public UserBean findUser(int idUser) {
		
		String sql = "SELECT * FROM USER WHERE ID_USER = ?";

		return this.jdbcTemplate.queryForObject(sql, new userMapper(), idUser);
		
	}
    
}
