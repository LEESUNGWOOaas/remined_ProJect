package com.level.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.level.admin.user.service.UserService;
import com.level.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/user/userList")
	public String list(UserVO userVO,Model model)throws Exception{
		List<UserVO> userList = userService.selectUserList(userVO);
		model.addAttribute("userList",userList);
		model.addAttribute("pageVO",userVO.getPageVO());
		return "user/userList.admin";
	}
	
	
}
