package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkExperienceBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String startTime;
     private String endTime;
     private String uintOrDepartment;
     private String postOrProtitle;
     private String remark3;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUintOrDepartment() {
		return uintOrDepartment;
	}
	public void setUintOrDepartment(String uintOrDepartment) {
		this.uintOrDepartment = uintOrDepartment;
	}
	public String getPostOrProtitle() {
		return postOrProtitle;
	}
	public void setPostOrProtitle(String postOrProtitle) {
		this.postOrProtitle = postOrProtitle;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

     







}