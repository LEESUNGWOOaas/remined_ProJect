package com.level.admin.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.level.admin.board.service.BoardService;
import com.level.vo.BoardVO;

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
	@RequestMapping("/admin/board/{boardNo}")
	public String view(BoardVO boardVO,Model model)throws Exception{
		boardVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO",boardVO);
		
		return "board/boardView.admin";
	}
	
	@RequestMapping("/admin/board/boardForm")
	public String form(BoardVO boardVO,Model model)throws Exception{
		boardVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO",boardVO);
		
		return "board/boardForm.admin";
	}
	
	@ResponseBody
	@RequestMapping("/admin/board/save")
	public Map<String, Object>insert(BoardVO boardVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.insert(boardVO);
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","저장되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/admin/board/delete")
	public Map<String, Object> delete(BoardVO boardVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.delete(boardVO);
		if(result>0) {
			resultMap.put("result",true);
			resultMap.put("msg","삭제되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
}
