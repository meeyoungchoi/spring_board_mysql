package com.spring.db.jdbc.board.model;

public class BoardVO {
	/*
	 * create table jdbc_board (
	board_No int primary key auto_increment,
    writer varchar(100) not null, 
    title varchar(255) not null,
    content text



);
	 * 
	 * 
	 * */
	
	private int boardNo;
	private String writer;
	private String title;
	private String content;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
