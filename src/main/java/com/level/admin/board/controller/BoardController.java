package com.level.admin.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.level.admin.board.service.BoardService;
import com.level.vo.BoardVO;
import com.level.vo.UserVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/admin/board/boardList")
	public String list(BoardVO boardVO,Model model)throws Exception {
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",boardVO.getPageVO());
		return "board/boardList.admin";
	}
	
}
