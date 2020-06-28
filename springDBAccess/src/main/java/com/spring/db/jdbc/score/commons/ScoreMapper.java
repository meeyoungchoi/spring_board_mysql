package com.spring.db.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.db.jdbc.score.model.ScoreVO;


//JDBC Template에서 ResultSet 사용을 편하게 하기 위한 클래스 생성
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
