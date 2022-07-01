package com.level.admin.popup.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.level.vo.PopupVO;

public interface PopupService {

	List<PopupVO> selectPopupList(PopupVO popupVO)throws Exception;

	PopupVO selectPopup(PopupVO popupVO)throws Exception;

	int insert(PopupVO popupVO, MultipartHttpServletRequest multiPart)throws Exception;

	int delete(PopupVO popupVO)throws Exception;

	
}
