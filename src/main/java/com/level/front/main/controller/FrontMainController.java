package com.level.front.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.level.admin.board.service.BoardService;
import com.level.admin.introduce.service.IntroduceService;
import com.level.vo.BoardVO;
import com.level.vo.IntroduceVO;
import com.level.vo.PopupVO;

@Controller
public class FrontMainController {
	@Autowired
	BoardService boardService;
	@Autowired
	IntroduceService introduceService;
	@RequestMapping("/")
	public String a() {
		
		return "redirect:/front/main";
	}
	
	@RequestMapping("/front")
	public String index() {
		
		return "redirect:/front/main";
	}
	
	@RequestMapping("/front/main")
	public String main(BoardVO boardVO,IntroduceVO introduceVO,PopupVO popupVO,Model model)throws Exception{
		boardVO.setListSize(3);
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list","list");
		model.addAttribute("pageVO",boardVO.getPageVO());
		
		return "front/main";
	}
}
