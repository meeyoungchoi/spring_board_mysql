package com.spring.db.mybatis.score.repository;

import java.util.List;

import com.spring.db.mybatis.score.model.ScoreVO;

//I�� ���̴� ���� ����
//���� �����Ҷ� � ����� ������ ���ΰ�
//�߸��� ���̸� �Է¹��������� ������ ���� �ȴ�
//���� ������ �ݿ��� �Ǿ���Ѵ�
public interface IScoreMapper {
	//���� ��ϱ��
   void insertScore(ScoreVO scores);
	
	//���� ��ü ��ȸ ���
   List<ScoreVO> selectAllScores();
	
	//���� ���� ���
   void deleteScore(int stuNum);//����� ����

	
	//���� ���� ��ȸ ���
   ScoreVO selectOne(int stuNum);
}
