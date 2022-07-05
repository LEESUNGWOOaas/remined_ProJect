package com.level.admin.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.level.admin.user.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/admin"})
	public String index(){
		return  "redirect:/admin/main";
	}
	
	@RequestMapping("/admin/main")
	public String list(){
			
		return "redirect:/admin/board/boardList";
	}
}
