package com.spring.db.jdbc.board.repository;

import java.util.List;

import com.spring.db.jdbc.board.model.BoardVO;

public interface IBoardDAO {
	
	//�Խñ� ��� ��������
	List<BoardVO> getArticles();
	
	//�Խñ� ���
	void insertArticle(BoardVO board);
	
	//�Խñ� ����
	void deleteArticle(int index);//�۹�ȣ
	
	//�Խñ� �� ����
	BoardVO getContent(int index);
	
	//�Խñ� ����
	void modifyArticle(BoardVO article, int index);//������� �����ߴ°�
}
