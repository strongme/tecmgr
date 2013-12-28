package org.strongme.tecmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.OverAllPlanBean;
import org.strongme.tecmgr.service.OverAllPlanService;

@Controller
@RequestMapping("overAllPlan")
public class OverAllPlanController {
	
	@Resource
	private OverAllPlanService overAllPlanService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") OverAllPlanBean form
			,BindingResult results
			) {
		boolean result = false;
		if(!overAllPlanService.isExist(form.getTeacherId())) {
			int r = overAllPlanService.save(form);
			if(r>0)result = true;
		}else {
			int r = overAllPlanService.update(form);
			if(r>0)result = true;
		}
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody OverAllPlanBean get(@RequestParam String teacherId) {
		OverAllPlanBean result = overAllPlanService.get(teacherId);
		return result;
	}

}
