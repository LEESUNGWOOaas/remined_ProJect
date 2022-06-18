package com.level.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.level.admin.user.service.UserService;
import com.level.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public String list(UserVO userVO,Model model)throws Exception{
		List<UserVO> userList = userService.selectUserList(userVO);
		model.addAttribute("userList",userList);
		
		return "user/userList.admin";
	}
}
