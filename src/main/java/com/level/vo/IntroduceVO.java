package com.level.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("introduceVO")
public class IntroduceVO extends CommonVO{
	private int introduceNo;
	private String title;
	private String content;
	private String introduceUser;
	private String deleteYn;
	private String popupYn;

	Timestamp insertDate;

	public int getIntroduceNo() {
		return introduceNo;
	}

	public void setIntroduceNo(int introduceNo) {
		this.introduceNo = introduceNo;
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

	public String getIntroduceUser() {
		return introduceUser;
	}

	public void setIntroduceUser(String introduceUser) {
		this.introduceUser = introduceUser;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getPopupYn() {
		return popupYn;
	}

	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	
	
	
}
