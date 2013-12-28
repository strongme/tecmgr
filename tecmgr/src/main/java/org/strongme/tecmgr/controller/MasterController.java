package org.strongme.tecmgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.tecmgr.bean.TeacherRecordBean;
import org.strongme.tecmgr.service.HonourService;
import org.strongme.tecmgr.service.OverAllPlanService;
import org.strongme.tecmgr.service.SectionLittleSummaryService;
import org.strongme.tecmgr.service.SectionSummaryService;
import org.strongme.tecmgr.service.TeacherBasicInfoService;
import org.strongme.tecmgr.service.TeacherRecordService;
import org.strongme.tecmgr.service.WorkAwardService;
import org.strongme.tecmgr.service.WorkBookWriteService;
import org.strongme.tecmgr.service.WorkCommSupportService;
import org.strongme.tecmgr.service.WorkContinueLearnService;
import org.strongme.tecmgr.service.WorkExperienceService;
import org.strongme.tecmgr.service.WorkLearningService;
import org.strongme.tecmgr.service.WorkLectureService;
import org.strongme.tecmgr.service.WorkProMoralService;
import org.strongme.tecmgr.service.WorkSurveyService;
import org.strongme.tecmgr.service.WorkTeachResearchService;
import org.strongme.tecmgr.service.WorkTeachSkillService;
import org.strongme.tecmgr.service.WorkTeachingService;

@Controller
@RequestMapping("master")
public class MasterController {
	
	
	@Resource
	private TeacherRecordService teacherRecordService;
	@Resource
	private TeacherBasicInfoService teacherBasicInfoService;
	@Resource
	private HonourService honourService;
	@Resource
	private WorkExperienceService workExperienceService;
	@Resource
	private OverAllPlanService overAllPlanService;
	@Resource
	private SectionSummaryService sectionSummaryService;
	@Resource
	private SectionLittleSummaryService sectionLittleSummaryService;
	@Resource
	private WorkLectureService workLectureService;
	@Resource
	private WorkSurveyService workSurveyService;
	@Resource
	private WorkAwardService workAwardService;
	@Resource
	private WorkTeachResearchService workTeachResearchService;
	@Resource
	private WorkBookWriteService workBookWriteService;
	@Resource
	private WorkTeachingService workTeachingService;
	@Resource
	private WorkLearningService workLearningService;
	@Resource
	private WorkContinueLearnService workContinueLearnService;
	@Resource
	private WorkTeachSkillService workTeachSkillService;
	@Resource
	private WorkCommSupportService workCommSupportService;
	@Resource
	private WorkProMoralService workProMoralService;
	
	@RequestMapping(value="/query",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody List<TeacherRecordBean> query(
			@RequestParam String zzmm,
			@RequestParam String subject,
			@RequestParam String degree,
			@RequestParam String title,
			@RequestParam String department,
			@RequestParam String name,
			@RequestParam String teacherid
			) {
		return teacherRecordService.doquery(zzmm, subject, degree, title, department,name,teacherid);
	}

	@RequestMapping(value="/queryPreview/{teacherid}",method=RequestMethod.GET)
	public String query(@PathVariable String teacherid,Model model) {
		model.addAttribute("teacherBasicInfo", teacherBasicInfoService.get(teacherid));
		model.addAttribute("honourInfo", honourService.get(teacherid));
		model.addAttribute("workExpInfo", workExperienceService.get(teacherid));
		model.addAttribute("wholeGrowPlan", overAllPlanService.get(teacherid));
		model.addAttribute("periodGrowPlan", sectionSummaryService.get(teacherid));
		model.addAttribute("sl1", sectionLittleSummaryService.get(teacherid,1));
		model.addAttribute("sl2", sectionLittleSummaryService.get(teacherid,2));
		model.addAttribute("sl3", sectionLittleSummaryService.get(teacherid,3));
		model.addAttribute("workLecture", workLectureService.get(teacherid));
		model.addAttribute("workSurvey", workSurveyService.get(teacherid));
		model.addAttribute("workAward", workAwardService.get(teacherid));
		model.addAttribute("workTeachResearch", workTeachResearchService.get(teacherid));
		model.addAttribute("workBookWrite", workBookWriteService.get(teacherid));
		model.addAttribute("workTeaching", workTeachingService.get(teacherid));
		model.addAttribute("workLearning", workLearningService.get(teacherid));
		model.addAttribute("workContinueLearn", workContinueLearnService.get(teacherid));
		model.addAttribute("workTeachSkill", workTeachSkillService.get(teacherid));
		model.addAttribute("workCommSupport", workCommSupportService.get(teacherid));
		model.addAttribute("workProMoral", workProMoralService.get(teacherid));
		return "preview";
	}
	
}
