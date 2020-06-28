package com.spring.db.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {
	@Autowired
	private IBoardDAO dao;
	
	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles();
	}

	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);
	

	}

	@Override
	public void deleteArticle(int index) {
		dao.deleteArticle(index);

	}

	@Override
	public BoardVO getContent(int index) {
		BoardVO board = dao.getContent(index);
		System.out.println(board.toString());
		return board;
	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		dao.modifyArticle(article, index);

	}

}
