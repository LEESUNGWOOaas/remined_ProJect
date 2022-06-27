package com.level.admin.introduce.service;

import java.util.List;

import com.level.vo.IntroduceVO;

public interface IntroduceService {

	List<IntroduceVO> selectIntroduceList(IntroduceVO introduceVO)throws Exception;

	IntroduceVO selectIntroduce(IntroduceVO introduceVO)throws Exception;

	int insert(IntroduceVO introduceVO)throws Exception;

	int delete(IntroduceVO introduceVO)throws Exception;


}
