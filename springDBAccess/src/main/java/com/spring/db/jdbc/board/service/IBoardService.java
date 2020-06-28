package com.spring.db.jdbc.board.service;

import java.util.List;

import com.spring.db.jdbc.board.model.BoardVO;

public interface IBoardService {
	
	
	//게시글 목록 가져오기
		List<BoardVO> getArticles();
		
		//게시글 등록
		void insertArticle(BoardVO board);
		
		//게시글 삭제
		void deleteArticle(int index);//글번호
		
		//게시글 상세 보기
		BoardVO getContent(int index);
		
		//게시글 수정
		void modifyArticle(BoardVO article, int index);//몇번글을 수정했는가
}
