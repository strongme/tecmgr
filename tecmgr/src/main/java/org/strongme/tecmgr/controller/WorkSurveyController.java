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
import org.strongme.tecmgr.bean.WorkSurveyBean;
import org.strongme.tecmgr.service.WorkSurveyService;

@Controller
@RequestMapping("workSurvey")
public class WorkSurveyController {
	
	@Resource
	private WorkSurveyService workSurveyService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkSurveyBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workSurveyService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkSurveyBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workSurveyService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkSurveyBean> get(@RequestParam String teacherId) {
		List<WorkSurveyBean> result = workSurveyService.get(teacherId);
		return result;
	}

}
