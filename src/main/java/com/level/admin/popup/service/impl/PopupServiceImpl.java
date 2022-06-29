package com.level.admin.popup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.popup.service.PopupService;
import com.level.vo.PageVO;
import com.level.vo.PopupVO;

@Service
public class PopupServiceImpl implements PopupService{
	@Autowired
	PopupMapper mapper;

	@Override
	public List<PopupVO> selectPopupList(PopupVO popupVO) throws Exception {
		if(popupVO.isPaging()) popupVO.setPageVO(new PageVO(popupVO.getBlockSize(),popupVO.getListSize(),popupVO.getPage(),mapper.selectPopupListCount(popupVO)));
		return mapper.selectPopupList(popupVO);
	}

	@Override
	public PopupVO selectPopup(PopupVO popupVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectPopup(popupVO);
	}

	@Override
	public int insert(PopupVO popupVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.insert(popupVO);
	}
	
}
