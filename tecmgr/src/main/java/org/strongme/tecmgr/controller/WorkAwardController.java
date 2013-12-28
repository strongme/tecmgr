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
import org.strongme.tecmgr.bean.WorkAwardBean;
import org.strongme.tecmgr.service.WorkAwardService;

@Controller
@RequestMapping("workAward")
public class WorkAwardController {
	
	@Resource
	private WorkAwardService workAwardService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkAwardBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workAwardService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkAwardBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workAwardService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkAwardBean> get(@RequestParam String teacherId) {
		List<WorkAwardBean> result = workAwardService.get(teacherId);
		return result;
	}

}
