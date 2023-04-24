package com.comit.simplehr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.comit.simplehr.service.SimplehrService;

import com.comit.simplehr.bean.UserBean;

@Controller
public class SimplehrController {
	
	
	@Autowired
	SimplehrService SimplehrService;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/list")
	public ModelAndView list() {
        //logger.debug("Listing Users");
        
        List<UserBean> users = this.SimplehrService.listUsers();
        
		return new ModelAndView("list","users",users);
		
	}

}
