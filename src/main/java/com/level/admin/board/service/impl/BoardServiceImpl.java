package com.level.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.board.service.BoardService;
import com.level.vo.BoardVO;
import com.level.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		if(boardVO.isPaging()) boardVO.setPageVO(new PageVO(boardVO.getBlockSize(),boardVO.getListSize(),boardVO.getPage(),mapper.selectBoardListCount(boardVO)));
		return mapper.selectBoardList(boardVO);
	}
	
}
