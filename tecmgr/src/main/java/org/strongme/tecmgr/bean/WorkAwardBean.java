package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkAwardBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String name;
     private String time;
     private String award;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
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