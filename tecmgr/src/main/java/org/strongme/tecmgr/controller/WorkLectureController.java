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
import org.strongme.tecmgr.bean.WorkLectureBean;
import org.strongme.tecmgr.service.WorkLectureService;

@Controller
@RequestMapping("workLecture")
public class WorkLectureController {
	
	@Resource
	private WorkLectureService workLectureService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") WorkLectureBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workLectureService.save(form);
		if(r>0)result = true;
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean update(
			@ModelAttribute("form") WorkLectureBean form
			,BindingResult results
			) {
		boolean result = false;
		int r = workLectureService.update(form);
		if(r>0)result = true;
		return result;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<WorkLectureBean> get(@RequestParam String teacherId) {
		List<WorkLectureBean> result = workLectureService.get(teacherId);
		return result;
	}

}
