package org.strongme.tecmgr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.TeacherRecordBean;
import org.strongme.tecmgr.service.TeacherRecordService;

@Controller
public class SignController {
	
	@Resource
	private TeacherRecordService teacherRecordService;
	
	@RequestMapping(value="/isExist",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Boolean isExist(@RequestParam String teacherid) {
		Boolean result = teacherRecordService.isExist(teacherid); 
		return result;
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signup(@RequestParam String teacherid,@RequestParam String password,@RequestParam String teachername,@RequestParam String departmentname,HttpServletRequest request) {
		TeacherRecordBean bean = new TeacherRecordBean( teacherid, departmentname, teachername, password);
		if(teacherRecordService.isExist(teacherid)) {
			return "index";
		}
		int result = teacherRecordService.save(bean);
		if(result<0) {
			return "redirect:/sign/signup";
		}else {
			if("admin".equals(teacherid)&&"admin".equals(password)) {
				request.getSession().setAttribute("ISMASTER", true);
				return "redirect:/sign/master";
			}
			request.setAttribute("teacher", bean);
			request.getSession().setAttribute("ISMASTER", false);
			return "index";
		}
	}

	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String signin(@RequestParam String teacherid,@RequestParam String password,HttpServletRequest request) {
		TeacherRecordBean bean = teacherRecordService.get(teacherid);
		if(bean==null) {
			request.setAttribute("tips", "该用户不存在");
			return "signin";
		}else if(bean!=null&&!password.equals(bean.getPassword())) {
			request.setAttribute("tips", "密码错误请确认后重新输入");
			return "signin";
		}else {
			if("admin".equals(teacherid)&&"admin".equals(bean.getPassword())) {
				request.getSession().setAttribute("ISMASTER", true);
				request.setAttribute("toggle", "none");
				return "redirect:/sign/master";
			}
			request.setAttribute("teacher", bean);
			request.getSession().setAttribute("ISMASTER", false);
			return "index";
		}
	}
	
	@RequestMapping(value="/direct/{teacherid}",method=RequestMethod.GET)
	public String direct(@PathVariable String teacherid,HttpServletRequest request) {
		TeacherRecordBean bean = teacherRecordService.get(teacherid);
		request.setAttribute("teacher", bean);
		request.setAttribute("toggle", "none");
		request.getSession().setAttribute("ISMASTER", true);
		return "index";
	}
	
	@RequestMapping(value="/getRecord",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody TeacherRecordBean getRecord(@RequestParam String teacherId) {
		return teacherRecordService.get(teacherId);	
	}
	
}
