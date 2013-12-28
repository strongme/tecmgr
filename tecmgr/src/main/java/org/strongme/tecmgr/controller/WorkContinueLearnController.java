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
import org.strongme.tecmgr.bean.WorkContinueLearnBean;
import org.strongme.tecmgr.service.WorkContinueLearnService;

@Controller
@RequestMapping("workContinueLearn")
public class WorkContinueLearnController {
	
	@Resource
	private WorkContinueLearnService workContinueLearnService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkContinueLearnBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workContinueLearnService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkContinueLearnBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workContinueLearnService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkContinueLearnBean> get(@RequestParam String teacherId) {
		List<WorkContinueLearnBean> result = workContinueLearnService.get(teacherId);
		return result;
	}

}
