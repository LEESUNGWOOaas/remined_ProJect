package com.level.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("popupVO")
public class PopupVO extends CommonVO{
	private String process= "popup";
	
	private int popupNo;
	private String title;
	private String content;
	private String lotationX;
	private String lotationY;
	private String useYn;
	private String contentType;
	private String startDate;
	private String endDate;
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

	public String getLotationX() {
		return lotationX;
	}

	public void setLotationX(String lotationX) {
		this.lotationX = lotationX;
	}

	public String getLotationY() {
		return lotationY;
	}

	public void setLotationY(String lotationY) {
		this.lotationY = lotationY;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProcess() {
		return process;
	}
	
	
}
