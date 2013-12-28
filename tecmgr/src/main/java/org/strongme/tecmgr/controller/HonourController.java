package org.strongme.tecmgr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.HonourBean;
import org.strongme.tecmgr.service.HonourService;

@Controller
@RequestMapping("honour")
public class HonourController {
	
	@Resource
	private HonourService honourService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean save(
			@ModelAttribute("from") HonourBean form
			,BindingResult results
			) {
		boolean result = false;
		if(!honourService.isExist(form.getTeacherid())) {
			int r = honourService.save(form);
			if(r>0)result = true;
		}else {
			int r = honourService.update(form);
			if(r>0)result = true;
		}
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody HonourBean get(@RequestParam String teacherId) {
		HonourBean result = honourService.get(teacherId);
		return result;
	}

}
