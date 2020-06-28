package com.spring.db.jdbc.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.db.jdbc.score.model.ScoreVO;
import com.spring.db.jdbc.score.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	//빈등록후 @Autowired를 통해 주입
	@Autowired
	private IScoreService service;
	
	//점수 등록 화면을 열어주는 처리를 하는 요청메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: GET");
		return "score/write-form";
	}
	
	//점수등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
	
		System.out.println("/score/register: POST");
		System.out.println("controller param: " + scores);
		
	
		service.insertScore(scores);
		
		return "score/write-result";
	}
	

	//점수 전체 조회를 처리하는 요청 메서드
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list: GET");
		
		//서비스가 dao한테 먼저 요청
		//List<ScoreVO> list = service.selectAllScores();
		
		//model을 사용해서 list.jsp로 넘겨준다
		//model.addAttribute("slist", list);
		//축약
		model.addAttribute("slist", service.selectAllScores());
		
	}
	
	@GetMapping("/delete")
	public String delete( int stuNum, RedirectAttributes ra) {//dao한테 삭제하라고 알려주기위해(@RequestParam파라미터와 파라미터값을 받을 변수명이 같을때 @RequestParam을 안써도된다)
		
		System.out.println("삭제할 학번: " + stuNum);
		
		//삭제처리 완료 후 list요처잉 들어갈수 있도록 처리
		 service.deleteScore(stuNum);
		 //리다이렉트 요청이  들어갈때 같이 들어간다
		ra.addFlashAttribute("msg", "delSuccess");
		return "redirect:/score/list";
	}
	
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search: GET");
	}
	
	
//	@GetMapping("/selectOne")
//	public String find(int stuNum, Model model, RedirectAttributes ra) {
//		System.out.println("조회할 학번: " + stuNum);
//		
//		if (service.selectOne(stuNum).equals(null)) {
//			ra.addFlashAttribute("msg", "selectFail");
//			System.out.println("존재하지 않는 학번입니다.");
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
		
		System.out.println("/score/selectOne: GET");
		
		// 학번이 잘못 들어올경우 대비 모든 학생의 정보를 전부 불러온다
//		List<ScoreVO> scores = service.selectAllScores();
//		
//		//잘못 입력된 학번인 경우
//		if (scores.size() < stuNum) {
//			ra.addFlashAttribute("msg", "학번 정보가 없습니다.");
//			return "redirect:/score/search";
//		} else {
			model.addAttribute("stu",service.selectOne(stuNum));
			return "score/search-result";
		
		
	
	}
	
	
}
