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
import org.strongme.tecmgr.bean.WorkCommSupportBean;
import org.strongme.tecmgr.service.WorkCommSupportService;

@Controller
@RequestMapping("workCommSupport")
public class WorkCommSupportController {
	
	@Resource
	private WorkCommSupportService workCommSupportService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkCommSupportBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workCommSupportService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkCommSupportBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workCommSupportService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkCommSupportBean> get(@RequestParam String teacherId) {
		List<WorkCommSupportBean> result = workCommSupportService.get(teacherId);
		return result;
	}

}
