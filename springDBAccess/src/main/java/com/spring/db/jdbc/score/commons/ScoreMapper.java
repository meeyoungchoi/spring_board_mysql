package com.spring.db.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.db.jdbc.score.model.ScoreVO;


//JDBC Template���� ResultSet ����� ���ϰ� �ϱ� ���� Ŭ���� ����
public class ScoreMapper implements RowMapper<ScoreVO> {

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {//sql���������� �����Ͱ� ���� ��ȸ�� �Ǿ������� �޶�(jDBC���ø��� �ش�)
		ScoreVO score = new ScoreVO();
		score.setStuId(rs.getInt("stu_id"));//�÷����� ����ִ´�
		score.setStuName(rs.getString("stu_name"));
		score.setKor(rs.getInt("kor"));
		score.setEng(rs.getInt("eng"));
		score.setMath(rs.getInt("math"));
		score.setTotal(rs.getInt("total"));
		score.setAverage(rs.getDouble("average"));
		
		
		return score;
	}


	
}
