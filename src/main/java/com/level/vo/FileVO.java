package com.level.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.level.common.util.AES256Util;
import com.level.common.util.BaseUtil;

@Alias("fileVO")
public class FileVO {

	private int fileNo;
	private String process;
	private int ref;
	private String kind;
	private String fileName;
	private String savePath;
	private String saveName;
	private String fileExt;
	private long fileSize;
	
	private String insertUser;
	private Timestamp insertDate;
	private int exceptNo;
	
	public FileVO() {
		
	}
	
	public FileVO(String process, int ref, String kind) {
		this.process = process;
		this.ref = ref;
		this.kind = kind;
	}
	
	
	public double getFileSizeMB() {
		return (double) Math.round(fileSize/(1024d*1024d)*100d)/100d;
	}
	
	public String getFileNoAES() throws Exception {
		AES256Util a256 = AES256Util.getInstance();
        return a256.encode(fileNo+"");
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public boolean isImage() {
		return BaseUtil.isImageExtension(fileExt);
	}
	
	public boolean isVideo() {
		return BaseUtil.isVideoExtension(fileExt);
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public int getExceptNo() {
		return exceptNo;
	}

	public void setExceptNo(int exceptNo) {
		this.exceptNo = exceptNo;
	}

	
	
}
