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
import org.strongme.tecmgr.bean.WorkTeachingBean;
import org.strongme.tecmgr.service.WorkTeachingService;

@Controller
@RequestMapping("workTeaching")
public class WorkTeachingController {
	
	@Resource
	private WorkTeachingService workTeachingService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkTeachingBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachingService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkTeachingBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachingService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkTeachingBean> get(@RequestParam String teacherId) {
		List<WorkTeachingBean> result = workTeachingService.get(teacherId);
		return result;
	}

}
