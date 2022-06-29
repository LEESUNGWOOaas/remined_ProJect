package com.level.admin.popup.service;

import java.util.List;

import com.level.vo.PopupVO;

public interface PopupService {

	List<PopupVO> selectPopupList(PopupVO popupVO)throws Exception;

	PopupVO selectPopup(PopupVO popupVO)throws Exception;

	int insert(PopupVO popupVO)throws Exception;

}
