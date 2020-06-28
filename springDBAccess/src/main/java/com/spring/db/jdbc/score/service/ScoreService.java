package com.spring.db.jdbc.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.score.model.ScoreVO;
import com.spring.db.jdbc.score.repository.IScoreDAO;

//dao객체가 필요하다
//값의 가고은 서비스에서 이루어진다
@Service
public class ScoreService implements IScoreService {
	//스프링 빈등록 객체 자동주입
	@Autowired
	private IScoreDAO dao;
	
	
	@Override
	public void insertScore(ScoreVO scores) {//컨트롤러가 부른다
		//컨트롤러로부터 받아서 dao로
		scores.calcData();
		dao.insertScore(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		//List<ScoreVO> list = dao.selectAllScores();
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int stuNum) {
		dao.deleteScore(stuNum);

		
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		ScoreVO score = dao.selectOne(stuNum);
		System.out.println(score.toString());
	
		return score;
	}

}
