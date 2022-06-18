package com.level.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.level.admin.user.service.UserService;
import com.level.common.util.SessionUtil;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/login")
	public String login()throws Exception{
		if(SessionUtil.isLogin()) return "redirect:/admin";
		return "admin/login/login";
	}
	@RequestMapping("/admin/logout")
	public String logout()throws Exception{
		return "";
	}
	
	public String CheckUser()throws Exception{
		return "";
	}
}
