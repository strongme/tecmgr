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
import org.strongme.tecmgr.bean.WorkProMoralBean;
import org.strongme.tecmgr.service.WorkProMoralService;

@Controller
@RequestMapping("workProMoral")
public class WorkProMoralController {
	
	@Resource
	private WorkProMoralService workProMoralService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkProMoralBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workProMoralService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkProMoralBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workProMoralService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkProMoralBean> get(@RequestParam String teacherId) {
		List<WorkProMoralBean> result = workProMoralService.get(teacherId);
		return result;
	}

}
