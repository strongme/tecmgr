package org.strongme.tecmgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.WorkLearningBean;
import org.strongme.tecmgr.service.WorkLearningService;

@Controller
@RequestMapping("workLearning")
public class WorkLearningController {
	
	@Resource
	private WorkLearningService workLearningService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkLearningBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workLearningService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkLearningBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workLearningService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkLearningBean> get(@RequestParam String teacherId) {
		List<WorkLearningBean> result = workLearningService.get(teacherId);
		return result;
	}

}
