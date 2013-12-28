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
import org.strongme.tecmgr.bean.WorkExperienceBean;
import org.strongme.tecmgr.service.WorkExperienceService;

@Controller
@RequestMapping("workExp")
public class WorkExperienceController {

	@Resource
	private WorkExperienceService workExperienceService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkExperienceBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workExperienceService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkExperienceBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workExperienceService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkExperienceBean> get(@RequestParam String teacherId) {
		List<WorkExperienceBean> result = workExperienceService.get(teacherId);
		return result;
	}
	
}
