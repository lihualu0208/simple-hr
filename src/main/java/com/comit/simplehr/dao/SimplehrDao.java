package com.comit.simplehr.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.comit.simplehr.bean.UserBean;
import com.comit.simplehr.util.Util;;

@Repository
public class SimplehrDao {

List<UserBean> users;
	
	public SimplehrDao() {
		this.users = new ArrayList<UserBean>();
				
		users.add(new UserBean(1,"John","Doe","jdoe","123",Util.parseDate("1992-02-04"),"A"));
		users.add(new UserBean(2,"Jane","Smith","jsmith","123",Util.parseDate("1995-06-07"),"A"));
		users.add(new UserBean(3,"Pete","Roberts","proberts","123",Util.parseDate("1984-07-09"),"A"));
	}
	
	public List<UserBean> listUsers() {
		
		return this.users;
	}
	
}
