package com.level.admin.popup.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.level.vo.PopupVO;

@Mapper
public interface PopupMapper {
	List<PopupVO> selectPopupList(PopupVO popupVO)throws Exception;

	int selectPopupListCount(PopupVO popupVO)throws Exception;
	
	PopupVO selectPopup(PopupVO popupVO)throws Exception;

	int insert(PopupVO popupVO)throws Exception;
}
