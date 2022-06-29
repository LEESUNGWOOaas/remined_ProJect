package com.level.admin.popup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.level.admin.popup.service.PopupService;
import com.level.vo.PopupVO;

@Controller
public class PopupController {
	@Autowired
	private PopupService popupService;
	
	@RequestMapping("/admin/popup/popupList")
	public String list(PopupVO popupVO,Model model) throws Exception{
		List<PopupVO> list = popupService.selectPopupList(popupVO);
		model.addAttribute("list",list);
		return "popup/popupList.admin";
	}
	
	@RequestMapping("/admin/popup/{popupNo}")
	public String view(PopupVO popupVO,Model model) throws Exception{
		popupVO = popupService.selectPopup(popupVO);
		model.addAttribute("popupVO",popupVO);
		return "popup/popupView.admin";
	}
	
	@RequestMapping("/admin/popup/popupForm")
	public String form(PopupVO popupVO,Model model)throws Exception{
		popupVO = popupService.selectPopup(popupVO);
		model.addAttribute("popupVO",popupVO);
		
		return "popup/popupForm.admin";
	}
	
	@ResponseBody
	@RequestMapping("/admin/popup/save")
	public Map<String, Object> save(PopupVO popupVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = popupService.insert(popupVO);
		if(result>0) {
			resultMap.put("result",true);
			resultMap.put("msg","저장되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
}
