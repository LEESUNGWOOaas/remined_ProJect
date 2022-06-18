package com.level.common.file.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.level.common.file.service.FileService;
import com.level.common.util.BaseUtil;
import com.level.common.util.SessionUtil;
import com.level.vo.FileVO;

@Service("FileService")
public class FileServiceImpl implements FileService{


	@Autowired
	private FileMapper mapper;
	
	
	@Value("${FILE.SERVER.PATH}")
	private String serverPath;
	
	
	
	
	@Override
	public List<FileVO> selectFileList(FileVO fileVO) throws Exception{
		return mapper.selectFileList(fileVO);
	}
	
	
	public long getFileSize(MultipartFile multipartFile) throws Exception {
		return multipartFile.isEmpty()? 0 : multipartFile.getSize();
	}
	
	@Override
	public FileVO saveFile(MultipartFile multipartFile, String process, int ref, String kind) throws Exception{
		if(multipartFile.isEmpty()) return null;
		
		
		FileVO fileVO = new FileVO();
		
		//파일 용량 체크
		/*if(!isFileSizeOK(multipartFile)) {
			System.out.println("용량 초과");
			return null;
		}*/
		
		
		//String fileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
		String fileName = multipartFile.getOriginalFilename();
		System.out.println("fileName = "+fileName);
		String fileExt = StringUtils.getFilenameExtension(fileName);
		String saveName = UUID.randomUUID().toString()+"."+fileExt;
		long fileSize = getFileSize(multipartFile);
		String savePath = "/upload/"+process+"/";
		String uploadPath = serverPath+savePath;
		
		File dir = new File(uploadPath);
		if(!dir.exists()) dir.mkdirs();
		
		File uploadFile = new File(uploadPath+saveName);
		multipartFile.transferTo(uploadFile);
		
		if(!uploadFile.exists()) {
			return null;
		}
		
		fileVO.setFileName(fileName);
		fileVO.setSavePath(savePath);
		fileVO.setSaveName(saveName);
		fileVO.setFileExt(fileExt);
		fileVO.setFileSize(fileSize);
		fileVO.setProcess(process);
		fileVO.setRef(ref);
		fileVO.setKind(kind);
		fileVO.setInsertUser(SessionUtil.getCurrentUserId());
		mapper.insert(fileVO);
		System.out.println("kind = "+kind);
		return fileVO;
	}
	
	@Override
	public FileVO saveCKImage(MultipartFile multipartFile) throws Exception{
		if(multipartFile.isEmpty()) return null;
		
		FileVO fileVO = new FileVO();
		
		String fileName = multipartFile.getOriginalFilename();
		String fileExt = StringUtils.getFilenameExtension(fileName);
		String saveName = UUID.randomUUID().toString()+"."+fileExt;
		long fileSize = getFileSize(multipartFile);
		String savePath = "/upload/ckeditor/"+BaseUtil.currentYM()+"/";
		String uploadPath = serverPath+savePath;
		
		File dir = new File(uploadPath);
		if(!dir.exists()) dir.mkdirs();
		
		File uploadFile = new File(uploadPath+saveName);
		multipartFile.transferTo(uploadFile);
		
		if(!uploadFile.exists()) {
			return null;
		}
		
		fileVO.setFileName(fileName);
		fileVO.setSavePath(savePath);
		fileVO.setSaveName(saveName);
		fileVO.setFileExt(fileExt);
		fileVO.setFileSize(fileSize);
		
		return fileVO;
	}
	
	@Override
	public FileVO getFile(FileVO fileVO) throws Exception{
		return mapper.getFile(fileVO);
	}
	
	@Override
	public int delete(FileVO fileVO) throws Exception{
		fileVO = mapper.getFile(fileVO);
		int result = mapper.delete(fileVO);
		if(result>0) deleteFile(fileVO);
		return result;
	}
	
	@Override
	public void deleteOldFile(FileVO fileVO) throws Exception{
		List<FileVO> list = mapper.selectFileList(fileVO);
		for(FileVO item : list) {
			int result = mapper.delete(item);
			if(result>0) deleteFile(item);
		}
	}
	
	public void deleteFile(FileVO fileVO) {
		File f1 = new File(serverPath+"/"+fileVO.getSavePath()+fileVO.getSaveName());
		if(f1.exists()) {
			f1.delete();
		}
	}
	
}
