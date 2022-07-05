package com.level.front.introduce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.level.admin.introduce.service.IntroduceService;
import com.level.vo.IntroduceVO;

@Controller
public class FrontIntroduceController {
	@Autowired
	IntroduceService introduceService;
	
	@RequestMapping("/front/introduce/introduceList")
	public String list(IntroduceVO introduceVO,Model model)throws Exception{
		List<IntroduceVO> list=introduceService.selectIntroduceList(introduceVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",introduceVO.getPageVO());
		return "front/introduce/introduceList";
	}
	
	@RequestMapping("/front/introduce/{introduceNo}")
	public String view(IntroduceVO introduceVO,Model model)throws Exception{
		introduceVO = introduceService.selectIntroduce(introduceVO);
		model.addAttribute("introduceVO",introduceVO);
		
		return "front/introduce/introduceView";
	}
	@RequestMapping("/front/introduce/introduceForm")
	public String form(IntroduceVO introduceVO,Model model)throws Exception{
		introduceVO = introduceService.selectIntroduce(introduceVO);
		model.addAttribute("introduceVO",introduceVO);
		return "front/introduce/introduceForm";
	}
	
	@ResponseBody
	@RequestMapping("/front/introduce/save")
	public Map<String, Object>save(IntroduceVO introduceVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = introduceService.insert(introduceVO);
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
	@RequestMapping("/front/introduce/delete")
	public Map<String, Object>delete(IntroduceVO introduceVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = introduceService.delete(introduceVO);
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
