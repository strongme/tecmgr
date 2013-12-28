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
import org.strongme.tecmgr.bean.WorkBookWriteBean;
import org.strongme.tecmgr.service.WorkBookWriteService;

@Controller
@RequestMapping("workBookWrite")
public class WorkBookWriteController {
	
	@Resource
	private WorkBookWriteService workBookWriteService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkBookWriteBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workBookWriteService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkBookWriteBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workBookWriteService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkBookWriteBean> get(@RequestParam String teacherId) {
		List<WorkBookWriteBean> result = workBookWriteService.get(teacherId);
		return result;
	}

}
