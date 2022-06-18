package com.level.vo;

import java.util.List;

import com.level.vo.FileVO;

public class CommonVO {

	private int page = 1; // 현재 표시되는 페이지
	private int listSize = 10; //페이지당 표시될 개수
	private int blockSize = 10; // 블럭의 갯수
	private boolean isPaging = true; // paging
	
	private String searchType; // 검색타입
	private String searchKeyword; // 검색 키워드
	
	private String orderBy; 
	
	private String arr;
	private PageVO pageVO;
	private List<FileVO> fileList;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public boolean isPaging() {
		return isPaging;
	}
	public void setPaging(boolean isPaging) {
		this.isPaging = isPaging;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public List<FileVO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileVO> fileList) {
		this.fileList = fileList;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	
}
