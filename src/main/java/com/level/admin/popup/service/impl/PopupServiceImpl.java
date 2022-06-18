package com.level.admin.popup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.popup.service.PopupService;

@Service
public class PopupServiceImpl implements PopupService{
	@Autowired
	PopupMapper mapper;
}
