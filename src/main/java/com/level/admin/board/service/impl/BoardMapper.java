package com.level.admin.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.level.vo.BoardInfoVO;
import com.level.vo.BoardVO;
import com.level.vo.UserVO;

@Mapper
public interface BoardMapper {

	BoardInfoVO selectBoardInfo(BoardInfoVO boardInfoVO)throws Exception;
	
	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;
	
	int selectBoardListCount(BoardVO boardVO)throws Exception;
	
}
