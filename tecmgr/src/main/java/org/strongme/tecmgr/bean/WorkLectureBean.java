package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkLectureBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String time;
     private String name;
     private String range;
     private String org;
     private String proff;
     private String remark;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getProff() {
		return proff;
	}
	public void setProff(String proff) {
		this.proff = proff;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


     







}