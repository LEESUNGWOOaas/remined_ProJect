package com.level.admin.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.level.admin.user.service.UserService;
import com.level.common.util.SHA256Util;
import com.level.common.util.SessionUtil;
import com.level.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/login")
	public String login()throws Exception{
		if(SessionUtil.isLogin()) return "redirect:/admin/main";
		return "admin/login/login";
	}
	@RequestMapping("/admin/logout")
	public String logout()throws Exception{
		if(SessionUtil.isLogin())
			SessionUtil.removeUser();
		return "redirect:/admin/login";
	}
	@ResponseBody
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public Map<String,Object> CheckUser(UserVO memberVO,Model model,HttpSession session)throws Exception{
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		UserVO userVO=userService.selectUserById(memberVO.getUserId());
		if(userVO == null||
				!userVO.getDeleteYn().equals("N")||
				!SHA256Util.getEncrypt(memberVO.getPwd(),userVO.getHash()).equals(userVO.getPwd())){
			  	resultMap.put("result",false);
			  	resultMap.put("msg","잘못된 정보입니다.");
		  }else {
			  SessionUtil.setUser(userVO); 
			  System.out.println("로그인 성공");
			  
			  resultMap.put("result",true); 
			  resultMap.put("redirectUrl", "/admin/main");
			  
		  }
		return resultMap;
	}
}
