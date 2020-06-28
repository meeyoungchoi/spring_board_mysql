package com.spring.db.jdbc.score.repository;

import java.util.List;

import com.spring.db.jdbc.score.model.ScoreVO;

//I를 붙이는 것이 관례
//디비와 연동할때 어떤 기능을 구현할 것인가
//잘못된 값이면 입력받을때부터 차단이 들어가야 된다
//디비는 무조건 반영이 되어야한다
public interface IScoreDAO {
	//점수 등록기능
   void insertScore(ScoreVO scores);
	
	//점수 전체 조회 기능
   List<ScoreVO> selectAllScores();
	
	//점수 삭제 기능
   void deleteScore(int stuNum);//저장된 순서
	
	
	//점수 개별 조회 기능
   ScoreVO selectOne(int stuNum);
}
