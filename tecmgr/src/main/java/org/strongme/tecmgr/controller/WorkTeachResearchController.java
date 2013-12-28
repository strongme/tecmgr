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
import org.strongme.tecmgr.bean.WorkTeachResearchBean;
import org.strongme.tecmgr.service.WorkTeachResearchService;

@Controller
@RequestMapping("workTeachResearch")
public class WorkTeachResearchController {
	
	@Resource
	private WorkTeachResearchService workTeachResearchService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkTeachResearchBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachResearchService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkTeachResearchBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachResearchService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkTeachResearchBean> get(@RequestParam String teacherId) {
		List<WorkTeachResearchBean> result = workTeachResearchService.get(teacherId);
		return result;
	}

}
