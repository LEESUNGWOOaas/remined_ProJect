package com.level.common.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.level.vo.FileVO;

public interface FileService {
	

	List<FileVO> selectFileList(FileVO fileVO) throws Exception;
	
	long getFileSize(MultipartFile multipartFile) throws Exception;
	
	FileVO saveCKImage(MultipartFile multipartFile) throws Exception;
	
	int delete(FileVO fileVO) throws Exception;
	
	void deleteOldFile(FileVO fileVO) throws Exception;
	
	FileVO getFile(FileVO fileVO) throws Exception;

	FileVO saveFile(MultipartFile multipartFile, String process, int ref, String kind) throws Exception;
	
}

