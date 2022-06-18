package com.level.common.file.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.level.common.file.service.FileService;
import com.level.common.util.AES256Util;
import com.level.common.util.BaseUtil;
import com.level.vo.FileVO;

@Controller
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@Value("${FILE.SERVER.PATH}")
	private String serverPath;
	
	
	@ResponseBody
    @RequestMapping("/common/file/ckeditor/upload")
    public Map<String, Object> ckUpload(@RequestParam MultipartFile upload) throws Exception {
    	Map<String, Object> resultMap = new  HashMap<String, Object>();
    	
    	FileVO fileVO = fileService.saveCKImage(upload);
    	
    	resultMap.put("uploaded", true); //성공
		resultMap.put("url", fileVO.getSavePath()+fileVO.getSaveName());
		
    	return resultMap;
    }
	
	
	@RequestMapping("/common/file/download")
    public void download(FileVO fileVO, @RequestParam String fileId, HttpServletResponse response) throws Exception {
    	
    	AES256Util a256 = AES256Util.getInstance();
    	int fileNo = 0;
    	try {
    		fileNo = Integer.parseInt(a256.decode(fileId));
    		fileVO.setFileNo(fileNo);
    	}catch(Exception ex) {
    		response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('잘못된 접근입니다.');</script>");
			writer.flush();
			return;
    	}
    	
    	fileVO = fileService.getFile(fileVO);
    	if(BaseUtil.isEmpty(fileVO)) {
    		response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('잘못된 접근입니다.');</script>");
			writer.flush();
			return;
    	}
		
    	
		String uploadPath = serverPath + fileVO.getSavePath();

    	String filename = fileVO.getFileName();
    	File file = new File(uploadPath, fileVO.getSaveName());

    	try {
    		byte[] data = FileUtils.readFileToByteArray(file);
    		response.setContentType("application/octet-stream");
    		response.setContentLength(data.length);
    		response.setHeader("Content-Transfer-Encoding", "binary");
    		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(filename, "UTF-8") + "\";");

    		response.getOutputStream().write(data);
    		response.getOutputStream().flush();
    		response.getOutputStream().close();

    	} catch (IOException e) {
    		response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('파일 다운로드에 실패하였습니다.');</script>");
			writer.flush();
    	}
    	
	}
	
	
	@RequestMapping("/common/file/uploadSample")
	public void uploadSample(HttpServletResponse response, String uploadFormName) throws Exception {
		
		ClassPathResource lectureUploadForm = new ClassPathResource("uploadForm/"+uploadFormName+".xls");
		Path path = Paths.get(lectureUploadForm.getURI());
		
		String filename = "";
		if(uploadFormName.equals("bbsUploadForm")) filename="업로드양식.xls";
		
		File file = path.toFile();

    	try {
    		byte[] data = FileUtils.readFileToByteArray(file);
    		response.setContentType("application/octet-stream");
    		response.setContentLength(data.length);
    		response.setHeader("Content-Transfer-Encoding", "binary");
    		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(filename, "UTF-8") + "\";");

    		response.getOutputStream().write(data);
    		response.getOutputStream().flush();
    		response.getOutputStream().close();

    	} catch (IOException e) {
    		response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('파일 다운로드에 실패하였습니다.');</script>");
			writer.flush();
    	}
		
	}
	
    	
}
