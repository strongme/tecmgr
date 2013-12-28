package org.strongme.tecmgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.Department;
import org.strongme.tecmgr.service.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	
	@RequestMapping(value="/all",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<Department> all() {
		return departmentService.allDepartment();
	}

}
