package org.strongme.tecmgr.bean;

import java.util.Date;



public class OverAllPlanBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherId;
     private String planTime;
     private String eduIdea;
     private String advanced;
     private String disadvanced;
     private String remark;
     private String planDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getEduIdea() {
		return eduIdea;
	}
	public void setEduIdea(String eduIdea) {
		this.eduIdea = eduIdea;
	}
	public String getAdvanced() {
		return advanced;
	}
	public void setAdvanced(String advanced) {
		this.advanced = advanced;
	}
	public String getDisadvanced() {
		return disadvanced;
	}
	public void setDisadvanced(String disadvanced) {
		this.disadvanced = disadvanced;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPlanDetail() {
		return planDetail;
	}
	public void setPlanDetail(String planDetail) {
		this.planDetail = planDetail;
	}
     
     










}