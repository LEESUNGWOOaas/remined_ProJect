package com.level.admin.introduce.controller;

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
public class IntroduceController {

	@Autowired
	private IntroduceService introduceService;
	
	@RequestMapping("/admin/introduce/introduceList")
	public String List(IntroduceVO introduceVO,Model model)throws Exception{
		List<IntroduceVO> list = introduceService.selectIntroduceList(introduceVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",introduceVO.getPageVO());
		return "introduce/introduceList.admin";
	}

	@RequestMapping("/admin/introduce/{introduceNo}")
	public String View(IntroduceVO introduceVO,Model model)throws Exception{
		introduceVO = introduceService.selectIntroduce(introduceVO);
		model.addAttribute("introduceVO",introduceVO);
		return "introduce/introduceView.admin";
	}

	@RequestMapping("/admin/introduce/introduceForm")
	public String Form(IntroduceVO introduceVO,Model model)throws Exception{
		introduceVO = introduceService.selectIntroduce(introduceVO);
		model.addAttribute("introduceVO",introduceVO);
		
		return "introduce/introduceForm.admin";
	}

	@ResponseBody
	@RequestMapping("/admin/introduce/save")
	public Map<String, Object> save(IntroduceVO introduceVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = introduceService.insert(introduceVO);
		if(result>0) {
			resultMap.put("result",true);
			resultMap.put("msg","저장되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/admin/introduce/delete")
	public Map<String, Object> delete(IntroduceVO introduceVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = introduceService.delete(introduceVO);
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
