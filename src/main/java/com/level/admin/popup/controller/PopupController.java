package com.level.admin.popup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.level.admin.popup.service.PopupService;

@Controller
public class PopupController {
	@Autowired
	private PopupService popupService;
	
	public String list() throws Exception{
		return "";
	}
}
