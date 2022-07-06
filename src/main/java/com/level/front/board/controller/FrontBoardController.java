package com.level.front.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.level.admin.board.service.BoardService;
import com.level.vo.BoardVO;

@Controller
public class FrontBoardController {
	@Autowired 
	BoardService boardService;
	
	@RequestMapping("/front/board/boardList")
	public String list(BoardVO boardVO,Model model)throws Exception{
		boardVO.setListSize(3);
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",boardVO.getPageVO());
		return "front/board/boardList";
	}
	
	@RequestMapping("/front/board/{boardNo}")
	public String view(BoardVO boardVO,Model model)throws Exception{
			boardVO = boardService.selectBoard(boardVO);
			model.addAttribute("boardVO",boardVO);
		return "front/board/boardView";
	}
	
	@RequestMapping("/front/board/boardForm")
	public String form(BoardVO boardVO,Model model)throws Exception{
		boardVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO",boardVO);
		return "front/board/boardForm";
	}
	
	@ResponseBody
	@RequestMapping("/front/board/save")
	public Map<String, Object> save(BoardVO boardVO,MultipartHttpServletRequest multipart)throws Exception{
		Map<String, Object>resultMap = new HashMap<String, Object>();
			int result = boardService.insert(boardVO, multipart);
			if(result > 0) {
				resultMap.put("result",true);
				resultMap.put("msg","저장했습니다.");
			}else {
				resultMap.put("result",false);
				resultMap.put("msg","Error");
			}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/front/board/delete")
	public Map<String, Object> delete(BoardVO boardVO)throws Exception{
		Map<String, Object>resultMap = new HashMap<String, Object>();
			int result = boardService.delete(boardVO);
			if(result > 0) {
				resultMap.put("result",true);
				resultMap.put("msg","저장했습니다.");
			}else {
				resultMap.put("result",false);
				resultMap.put("msg","Error");
			}
		return resultMap;
	}
}
