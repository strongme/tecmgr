package org.strongme.tecmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.TeacherBasicInfoBean;
import org.strongme.tecmgr.service.TeacherBasicInfoService;

@Controller
@RequestMapping("basicInfo")
public class TeacherBasicInfoController {

	@Resource
	private TeacherBasicInfoService teacherBasicInfoService;
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") TeacherBasicInfoBean form
			,BindingResult results
			) {
		boolean result = false;
		if(!teacherBasicInfoService.isExist(form.getTeacherId())) {
			int r = teacherBasicInfoService.save(form);
			if(r>0)result = true;
		}else {
			int r = teacherBasicInfoService.update(form);
			if(r>0)result = true;
		}
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody TeacherBasicInfoBean get(@RequestParam String teacherId) {
		TeacherBasicInfoBean result = teacherBasicInfoService.get(teacherId);
		return result;
	}
}
