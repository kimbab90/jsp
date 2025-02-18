package com.yedam.vo;

import java.util.Date;

public class BoardVO {

	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;

	public BoardVO() {

	}

	public BoardVO(int boardNo, String title, String content, String writer, Date writeDate, int viewCnt) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.viewCnt = viewCnt;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

}
