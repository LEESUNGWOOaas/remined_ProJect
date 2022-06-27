package com.level.admin.introduce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.introduce.service.IntroduceService;
import com.level.vo.IntroduceVO;
import com.level.vo.PageVO;

@Service
public class IntroduceServiceImpl implements IntroduceService{
	@Autowired
	private IntroduceMapper mapper;

	@Override
	public List<IntroduceVO> selectIntroduceList(IntroduceVO introduceVO) throws Exception {
		if(introduceVO.isPaging()) introduceVO.setPageVO(new PageVO(introduceVO.getBlockSize(),introduceVO.getListSize(),introduceVO.getPage(),mapper.selectIntroduceListCount(introduceVO)));
		return mapper.selectIntroduceList(introduceVO);
	}

	@Override
	public IntroduceVO selectIntroduce(IntroduceVO introduceVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectIntroduce(introduceVO);
	}

	@Override
	public int insert(IntroduceVO introduceVO) throws Exception {
		if(introduceVO.getIntroduceNo()==0) {
			
			return mapper.insert(introduceVO);
		}else {

		}
		return mapper.update(introduceVO);	
		
	}

	@Override
	public int delete(IntroduceVO introduceVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(introduceVO);
	}
	
	
}
