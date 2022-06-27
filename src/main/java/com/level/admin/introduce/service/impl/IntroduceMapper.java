package com.level.admin.introduce.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.level.vo.IntroduceVO;

@Mapper
public interface IntroduceMapper {

	List<IntroduceVO> selectIntroduceList(IntroduceVO introduceVO)throws Exception;

	int selectIntroduceListCount(IntroduceVO introduceVO)throws Exception;
	
	IntroduceVO selectIntroduce(IntroduceVO introduceVO)throws Exception;

	int insert(IntroduceVO introduceVO)throws Exception;
	
	int delete(IntroduceVO introduceVO)throws Exception;

	int update(IntroduceVO introduceVO)throws Exception;
}
