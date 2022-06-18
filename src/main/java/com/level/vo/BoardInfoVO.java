package com.level.vo;

import org.apache.ibatis.type.Alias;

@Alias("boardInfoVO")
public class BoardInfoVO {
	private int boardInfoNo;
	private String boardTitle;
	private String useYn;
	private String popupYn;
	private String delete_yn;
	
	
	public int getBoardInfoNo() {
		return boardInfoNo;
	}
	public void setBoardInfoNo(int boardInfoNo) {
		this.boardInfoNo = boardInfoNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getPopupYn() {
		return popupYn;
	}
	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	
	
}
