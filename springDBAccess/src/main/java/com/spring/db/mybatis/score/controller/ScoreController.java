package com.spring.db.mybatis.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.db.mybatis.score.model.ScoreVO;
import com.spring.db.mybatis.score.service.IScoreService;

@Controller("scoreController2")
@RequestMapping("/mybatis/score")
public class ScoreController {
	
	//������ @Autowired�� ���� ����
	//@Qualifier("scoreService2") ����ִ°��� �����Ұ������� �˷���� �Ѵ�
	@Autowired
	@Qualifier("scoreService2")
	private IScoreService service;
	
	//���� ��� ȭ���� �����ִ� ó���� �ϴ� ��û�޼���
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: GET");
		return "score2/write-form";
	}
	
	//��������� ó���ϴ� ��û �޼���
	@PostMapping("/register")
	public String register(ScoreVO scores) {
	
		System.out.println("/score/register: POST");
		System.out.println("controller param: " + scores);
		
	
		service.insertScore(scores);
		
		return "score/write-result";
	}
	

	//���� ��ü ��ȸ�� ó���ϴ� ��û �޼���
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/score/list: GET");
		
		//���񽺰� dao���� ���� ��û
		//List<ScoreVO> list = service.selectAllScores();
		
		//model�� ����ؼ� list.jsp�� �Ѱ��ش�
		//model.addAttribute("slist", list);
		//���
		model.addAttribute("slist", service.selectAllScores());
		return "score2/list";
		
	}
	
	@GetMapping("/delete")
	public String delete( int stuNum, RedirectAttributes ra) {//dao���� �����϶�� �˷��ֱ�����(@RequestParam�Ķ���Ϳ� �Ķ���Ͱ��� ���� �������� ������ @RequestParam�� �Ƚᵵ�ȴ�)
		
		System.out.println("������ �й�: " + stuNum);
		
		//����ó�� �Ϸ� �� list��ó�� ���� �ֵ��� ó��
		 service.deleteScore(stuNum);
		 //�����̷�Ʈ ��û��  ���� ���� ����
		ra.addFlashAttribute("msg", "delSuccess");
		return "redirect:/mybatis/score/list";//�ٽ� ��Ʈ�ѷ��� ��û�� ������
	}
	
	@GetMapping("/search")
	public String search() {
		System.out.println("/score2/search: GET");
		return "score2/search";
	}
	
	
//	@GetMapping("/selectOne")
//	public String find(int stuNum, Model model, RedirectAttributes ra) {
//		System.out.println("��ȸ�� �й�: " + stuNum);
//		
//		if (service.selectOne(stuNum).equals(null)) {
//			ra.addFlashAttribute("msg", "selectFail");
//			System.out.println("�������� �ʴ� �й��Դϴ�.");
//			return "score/search-result";
//		}
//		
//		
//		model.addAttribute("stuNum" , stuNum);
//		model.addAttribute("stuOne", service.selectOne(stuNum));
//		
//		return "score/search-result";
//	}
//	
	
	@GetMapping("/selectOne")
	public String selectOne(int stuNum , Model model, RedirectAttributes ra) {
		
		System.out.println("/score2/selectOne: GET");
		
		// �й��� �߸� ���ð�� ��� ��� �л��� ������ ���� �ҷ��´�
//		List<ScoreVO> scores = service.selectAllScores();
//		
//		//�߸� �Էµ� �й��� ���
//		if (scores.size() < stuNum) {
//			ra.addFlashAttribute("msg", "�й� ������ �����ϴ�.");
//			return "redirect:/score/search";
//		} else {
			model.addAttribute("stu",service.selectOne(stuNum));
			return "score2/search-result";
		
		
	
	}
	
	
}
