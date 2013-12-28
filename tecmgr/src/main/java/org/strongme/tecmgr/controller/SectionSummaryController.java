package org.strongme.tecmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.SectionLittleSummaryBean;
import org.strongme.tecmgr.bean.SectionSummaryBean;
import org.strongme.tecmgr.service.SectionLittleSummaryService;
import org.strongme.tecmgr.service.SectionSummaryService;

@Controller
@RequestMapping("sectionSummary")
public class SectionSummaryController {
	
	@Resource
	private SectionSummaryService sectionSummaryService;
	@Resource
	private SectionLittleSummaryService sectionLittleSummaryService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") SectionSummaryBean form
			,BindingResult results
			) {
		boolean result = false;
		if(!sectionSummaryService.isExist(form.getTeacherId())) {
			int r = sectionSummaryService.save(form);
			if(r>0)result = true;
		}else {
			int r = sectionSummaryService.update(form);
			if(r>0)result = true;
		}
		return result;
	}
	
	@RequestMapping(value="/savetiny",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") SectionLittleSummaryBean form
			,BindingResult results
			) {
		boolean result = false;
		if(!sectionLittleSummaryService.isExist(form.getTeacherid(),form.getNum())) {
			int r = sectionLittleSummaryService.save(form);
			if(r>0)result = true;
		}else {
			int r = sectionLittleSummaryService.update(form);
			if(r>0)result = true;
		}
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody SectionSummaryBean get(@RequestParam String teacherId) {
		SectionSummaryBean result = sectionSummaryService.get(teacherId);
		return result;
	}

	@RequestMapping(value="/gettiny",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody SectionLittleSummaryBean getlittle(@RequestParam String teacherId,@RequestParam int num) {
		SectionLittleSummaryBean result = sectionLittleSummaryService.get(teacherId,num);
		return result;
	}
}
