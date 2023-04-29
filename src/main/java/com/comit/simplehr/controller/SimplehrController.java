package com.comit.simplehr.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.comit.simplehr.service.SimplehrService;
import com.comit.simplehr.util.Util;

import jakarta.servlet.http.HttpServletRequest;

import com.comit.simplehr.bean.UserBean;

@Controller
public class SimplehrController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SimplehrService SimplehrService;
	
	@GetMapping("/")
	public String index() {
		logger.debug("Landing Page");
		return "index";
	}
	
	
	@GetMapping("/list")
	public ModelAndView list() {
        logger.debug("Listing Users");
        
        List<UserBean> users = this.SimplehrService.listUsers();
        
		return new ModelAndView("list","users",users);
		
	}
	
	@GetMapping("/new")
	public String showcreate1() {
		logger.debug("show create Users");
		return "create";
	}
		
	@PostMapping("/create")
	public String createnew(HttpServletRequest req) {
		logger.debug("create new Users");
		String first=req.getParameter("first");
		String last=req.getParameter("last");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String birth=req.getParameter("birth");
		UserBean userBean=this.createUserbean("22",first,last,username,password,birth);
		
		this.SimplehrService.createUsers(userBean);
	
		return "redirect:/list";
	}
	
	public UserBean createUserbean(String id,String first,String last,String username,String password,String birth) {
		//UsrBean user=new UserBean(Util.parseId(id),first,last,username,password,Util.parseDate(birth),"");
		UserBean user = new UserBean(Util.parseId(id),first,last,username,password,Util.parseDate(birth),"A");
		
		
		return user;
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView updateShow(@PathVariable int id) {
		UserBean user=this.SimplehrService.findUser(id);
		return new ModelAndView("update","user",user);
		
	}
	@PostMapping("/update")
	public String updateUser(HttpServletRequest req) {
		logger.debug("update Users");
		String id=req.getParameter("id");
		String first=req.getParameter("first");
		String last=req.getParameter("last");
		String username=req.getParameter("username");
		//String password=req.getParameter("password");
		String birth=req.getParameter("birth");
		UserBean userBean=this.createUserbean(id,first,last,username,null,birth);
		
		this.SimplehrService.updateUsers(userBean);
	
		return "redirect:/list";
		
	
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		
		
	    logger.debug("Delete User");
		
	    this.SimplehrService.deleteUser(id);

		return "redirect:/list";

}
}
