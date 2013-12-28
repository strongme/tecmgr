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
import org.strongme.tecmgr.bean.WorkTeachSkillBean;
import org.strongme.tecmgr.service.WorkTeachSkillService;

@Controller
@RequestMapping("workTeachSkill")
public class WorkTeachSkillController {
	
	@Resource
	private WorkTeachSkillService workTeachSkillService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkTeachSkillBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachSkillService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkTeachSkillBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workTeachSkillService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkTeachSkillBean> get(@RequestParam String teacherId) {
		List<WorkTeachSkillBean> result = workTeachSkillService.get(teacherId);
		return result;
	}

}
