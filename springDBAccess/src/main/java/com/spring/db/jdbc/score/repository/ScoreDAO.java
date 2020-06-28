package com.spring.db.jdbc.score.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.score.commons.ScoreMapper;
import com.spring.db.jdbc.score.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {
	
	//내부클래스
	//ScoreMapper.java파일은 없어도 된다
	public class ScoreMapper implements RowMapper<ScoreVO> {

		@Override
		public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {//sql실행결과물과 데이터가 몇줄 조회가 되었는지를 달라(jDBC템플릿이 준다)
			ScoreVO score = new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));//컬럼값을 집어넣는다
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setEng(rs.getInt("eng"));
			score.setMath(rs.getInt("math"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			
			
			return score;
		}


		
	}

	

	//# 전통적 방식의 JDBC-단점: 코드가 길다
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";
//	private String uid = "root";
//	private String upw = "mysql";


	//	@Override
	//	public void insertScore(ScoreVO scores) {//컨트롤러가 서비스한테 시켜서 서비스가 보내줘야 한다
	//		
	//		Connection conn = null;
	//		PreparedStatement pstmt = null;
	//		
	//		//공백확인
	//		String sql = "INSERT INTO scores "
	//				+ "(stu_name, kor, eng, math, total, average) "
	//				+ "VALUES(?,?,?,?,?,?)";
	//		
	//		
	//		try {
	//			Class.forName(driver);
	//			conn = DriverManager.getConnection(url,uid,upw);
	//			pstmt = conn.prepareStatement(sql);//물음표를 채운다
	//
	//			pstmt.setString(1, scores.getStuName());
	//			pstmt.setInt(2, scores.getKor());
	//			pstmt.setInt(3, scores.getEng());
	//			pstmt.setInt(4, scores.getMath());
	//			pstmt.setInt(5, scores.getTotal());
	//			pstmt.setDouble(6, scores.getAverage());
	//			
	//			pstmt.executeUpdate();
	//			System.out.println("점수 등록 성공");
	//			
	//			
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}  finally {
	//	         try {
	//	             pstmt.close(); conn.close();
	//	          } catch (Exception e2) {
	//	             e2.printStackTrace();
	//	          }
	//	       }
	//
	//		
	//		
	//	}

	//# spring-jdbc방식의 처리: JDBCTemplate 사용!
	//히카리커넥션출과 히카리데이터소스가 다 주입되어져 있다
	//코드의 양을 줄일수 있다
	@Autowired
	private JdbcTemplate template;



	@Override
	public void insertScore(ScoreVO scores) {
		String sql = "INSERT INTO scores "
				+ "(stu_name, kor, eng, math, total, average) "
				+ "VALUES(?,?,?,?,?,?)";

		//jdbc템플릿 객체 사용
		//빈등록을 해놨기때문에 갖고오면된다
		//Object...args => ...은 가변인수(갯수가 지정되지 않았다 매개변수의 타입이 프로젝트마다 다르기때문에 타입이 오브젝트 타입이다)

		//처음매개변수는 String타입의 sql, 매개변수(?에 채울값)
		template.update(sql, scores.getStuName(), scores.getKor(), 
				scores.getEng(), scores.getMath(), scores.getTotal(), 
				scores.getAverage());



	}


//	@Override
//	public List<ScoreVO> selectAllScores() {
//		List<ScoreVO> list = new ArrayList<>();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		String sql = "SELECT * FROM scores";
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, uid, upw);
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while(rs.next()) {
//				ScoreVO vo = new ScoreVO();
//				vo.setStuId(rs.getInt("stu_id"));
//				vo.setStuName(rs.getString("stu_name"));
//				vo.setKor(rs.getInt("kor"));
//				vo.setEng(rs.getInt("eng"));
//				vo.setMath(rs.getInt("math"));
//				vo.setTotal(rs.getInt("total"));
//				vo.setAverage(rs.getDouble("average"));
//
//				list.add(vo);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close(); pstmt.close(); conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//
//
//		return list;
//	}
	
	@Override
	public List<ScoreVO> selectAllScores() {
		String sql = "SELECT * FROM scores";
		//RowMapper<ScoreVO> sm = new ScoreMapper();
		//인터페이스를 구현한 객체를 생성해서 보내줘야 한다
		ScoreMapper sm = new ScoreMapper();
//		List<ScoreVO> list = template.query(sql, sm);sql을 받아서 실행을 시킨후 rs를 받아서 ScoreMapper에게 전달해준다
	
//		return template.query(sql, sm);
//		return template.query(sql, new RowMapper<ScoreVO>() {//selectAllScores가 실행될때 마다 클래스가 생성되고 객체가 만들어진다

		//어처파 추상메소드가 하나뿐이여서 람다식으로 표현가능하다
		//장점: 한번쓸거 클래스를 따로 만들필요가 없다
		//return template.query(sql, (rs, rowNum)->{
//			@Override
//			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {//sql실행결과물과 데이터가 몇줄 조회가 되었는지를 달라(jDBC템플릿이 준다)
//				ScoreVO score = new ScoreVO();
//				score.setStuId(rs.getInt("stu_id"));//컬럼값을 집어넣는다
//				score.setStuName(rs.getString("stu_name"));
//				score.setKor(rs.getInt("kor"));
//				score.setEng(rs.getInt("eng"));
//				score.setMath(rs.getInt("math"));
//				score.setTotal(rs.getInt("total"));
//				score.setAverage(rs.getDouble("average"));
//				
//				
//				return score;
//			
//		});
		
		//클래스 선언문을 넣어놓고 객체만 생성하자
		return template.query(sql, new ScoreMapper());
	}
	
	
	
	
	

	@Override
	public void deleteScore(int stuNum) {
		
		String sql = "DELETE FROM scores where stu_id=?";
		
		template.update(sql, stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		
		String sql = "SELECT * FROM scores WHERE stu_id=?";//프라이머리키를 통한다
		
		
		//return template.queryForObject(sql, new ScoreMapper(),stuNum);//score하나만(딱 한명만 지목) 리턴할것이기때문
		
		//이것도 가능
//		return template.queryForObject(sql, (rs, rowNum) -> {
//			ScoreVO score = new ScoreVO();
//			score.setStuId(rs.getInt("stu_id"));//컬럼값을 집어넣는다
//			score.setStuName(rs.getString("stu_name"));
//			score.setKor(rs.getInt("kor"));
//			score.setEng(rs.getInt("eng"));
//			score.setMath(rs.getInt("math"));
//			score.setTotal(rs.getInt("total"));
//			score.setAverage(rs.getDouble("average"));
//			
//			
//			return score;
//		}, stuNum);
		
		//중복되기때문에
		//클래스 선언문을 넣어놓고 객체만 생성하자
		//딱한명의 객체만 지목해서 갖다준다
		return template.queryForObject(sql, new ScoreMapper(), stuNum);
	}

}
