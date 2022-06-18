package com.level.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("popupVO")
public class PopupVO {
	private int popupNo;
	private String title;
	private String content;
	private String deleteYn;
	
	Timestamp insertDate;

	public int getPopupNo() {
		return popupNo;
	}

	public void setPopupNo(int popupNo) {
		this.popupNo = popupNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	
	
}
