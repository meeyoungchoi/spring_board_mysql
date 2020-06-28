package com.spring.db.jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	
	//글작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	
	//글 작성 처리 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
	
		System.out.println("/board/write: POST");
	    service.insertArticle(article);
	   
		return "redirect:/board/list";
	}
	
	//글목록 화면
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
	
		
		model.addAttribute("articles", service.getArticles());
		
	}
	
	
	//글내용보기 요청
	@GetMapping("/content")
	public void getContent(@ModelAttribute("boardNo") int boardNo , Model model) {
		System.out.println("/board/content: GET");
		System.out.println("조회할 글번호: " + boardNo );
		//모델어트리뷰트가 글번호를  전달해준다
		//model.addAttribute("boardNo", boardNo);
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글수정하기 화면요청
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": GET");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article, int boardNo, Model model) {
		
		System.out.println("/board/modify?boardNo=" + boardNo + ": POST");
		service.modifyArticle(article, boardNo);
		return "redirect:/board/content?boardNo=" + boardNo;
	}
	
	//글삭제 -삭제완료되면 목록으로 이동
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete?boardNo= " + boardNo + ": GET");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	
}
