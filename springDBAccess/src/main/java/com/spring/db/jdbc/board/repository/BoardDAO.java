package com.spring.db.jdbc.board.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.board.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
/*
 * 	board_No int primary key auto_increment,
    writer varchar(100) not null, 
    title varchar(255) not null,
    content text
 * 
 * 
 * 
 * */
	
	
	
	//����Ŭ����
	public class BoardMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setBoardNo(rs.getInt("board_No"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setTitle(rs.getString("title"));
			return board;
		}
		
	}
	 
	@Autowired
	private JdbcTemplate template;


	@Override
	public List<BoardVO> getArticles() {
		String sql = "SELECT * FROM jdbc_board";
		BoardMapper sm = new BoardMapper();




		return template.query(sql, new BoardMapper());
	

	}

	@Override
	public void insertArticle(BoardVO article) {
		String sql = "INSERT INTO jdbc_board "
				+ "(board_No,writer,title,content) "
				+ "VALUES(?,?,?,?)";
				
		template.update(sql, article.getBoardNo(), article.getWriter(), article.getTitle(), article.getContent());
		
		System.out.println("�Խñ� ���� �Ϸ�!");
	}

	@Override
	public void deleteArticle(int boardNo) {
		String sql = "DELETE FROM jdbc_board where board_No=?";

		System.out.println((boardNo + 1) +"�� �Խù� �����Ϸ�");
		

		template.update(sql, boardNo);


	}

	@Override
	public BoardVO getContent(int boardNo) {
		String sql = "SELECT * FROM jdbc_board WHERE board_No=?";

		return template.queryForObject(sql, new BoardMapper(), boardNo);
	


	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		

	}

}
