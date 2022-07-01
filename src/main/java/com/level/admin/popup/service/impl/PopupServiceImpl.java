package com.level.admin.popup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.level.admin.popup.service.PopupService;
import com.level.common.file.service.FileService;
import com.level.vo.FileVO;
import com.level.vo.PageVO;
import com.level.vo.PopupVO;

@Service
public class PopupServiceImpl implements PopupService{
	@Autowired
	PopupMapper mapper;
	@Autowired
	FileService fileService;
	
	@Override
	public List<PopupVO> selectPopupList(PopupVO popupVO) throws Exception {
		if(popupVO.isPaging()) popupVO.setPageVO(new PageVO(popupVO.getBlockSize(),popupVO.getListSize(),popupVO.getPage(),mapper.selectPopupListCount(popupVO)));
		return mapper.selectPopupList(popupVO);
	}

	@Override
	public PopupVO selectPopup(PopupVO popupVO) throws Exception {
		popupVO = mapper.selectPopup(popupVO);
		if(popupVO!=null) {
			popupVO.setFileList(fileService.selectFileList(new FileVO(popupVO.getProcess(),popupVO.getPopupNo(),"File")));
		}
		return popupVO;
	}

	@Override
	public int insert(PopupVO popupVO,MultipartHttpServletRequest multiPart) throws Exception {
		int result = 0;
		
		if(popupVO.getPopupNo()==0) {
			result = mapper.insert(popupVO);
		}else{
			result = mapper.update(popupVO);
		}
		if(result > 0) {
			MultipartFile multi =multiPart.getFile("File"); 
			FileVO fileVO = fileService.saveFile(multi,popupVO.getProcess(),popupVO.getPopupNo(),"File");
			if(fileVO!=null) {
				fileVO.setExceptNo(fileVO.getFileNo());
				fileService.deleteOldFile(fileVO);
			}
		}	
		return result;
	}

	@Override
	public int delete(PopupVO popupVO) throws Exception {
		FileVO fileVO = new FileVO();
		fileVO.setRef(popupVO.getPopupNo());			
		fileService.deleteOldFile(fileVO);
		return mapper.delete(popupVO);
	}
	
}
