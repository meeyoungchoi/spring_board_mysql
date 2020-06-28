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
	
	
	//���ۼ� ȭ�� ��û
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	
	//�� �ۼ� ó�� ��û
	@PostMapping("/write")
	public String write(BoardVO article) {
	
		System.out.println("/board/write: POST");
	    service.insertArticle(article);
	   
		return "redirect:/board/list";
	}
	
	//�۸�� ȭ��
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
	
		
		model.addAttribute("articles", service.getArticles());
		
	}
	
	
	//�۳��뺸�� ��û
	@GetMapping("/content")
	public void getContent(@ModelAttribute("boardNo") int boardNo , Model model) {
		System.out.println("/board/content: GET");
		System.out.println("��ȸ�� �۹�ȣ: " + boardNo );
		//�𵨾�Ʈ����Ʈ�� �۹�ȣ��  �������ش�
		//model.addAttribute("boardNo", boardNo);
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//�ۼ����ϱ� ȭ���û
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": GET");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//�ۼ��� ó����û
	@PostMapping("/modify")
	public String modify(BoardVO article, int boardNo, Model model) {
		
		System.out.println("/board/modify?boardNo=" + boardNo + ": POST");
		service.modifyArticle(article, boardNo);
		return "redirect:/board/content?boardNo=" + boardNo;
	}
	
	//�ۻ��� -�����Ϸ�Ǹ� ������� �̵�
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete?boardNo= " + boardNo + ": GET");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	
}
