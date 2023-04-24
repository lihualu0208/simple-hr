package com.comit.simplehr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.simplehr.bean.UserBean;
import com.comit.simplehr.dao.SimplehrDao;

@Service
public class SimplehrService {
	@Autowired
	SimplehrDao simplehrDao;
	
	public List<UserBean> listUsers() {

		List<UserBean> users = this.simplehrDao.listUsers();
		
		return users;
	}


}
