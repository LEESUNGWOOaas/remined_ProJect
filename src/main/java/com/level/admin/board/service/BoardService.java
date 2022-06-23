package com.level.admin.board.service;

import java.util.List;

import com.level.vo.BoardInfoVO;
import com.level.vo.BoardVO;
import com.level.vo.UserVO;

public interface BoardService {

	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;

	BoardInfoVO selectBoardInfo(BoardInfoVO boardInfoVO)throws Exception;

	int insert(BoardVO boardVO)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

	BoardVO selectBoard(BoardVO boardVO)throws Exception;

}
