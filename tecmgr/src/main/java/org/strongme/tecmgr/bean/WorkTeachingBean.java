package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkTeachingBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String time;
     private Integer stunum;
     private String learnGuide;
     private String honour;
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
	public Integer getStunum() {
		return stunum;
	}
	public void setStunum(Integer stunum) {
		this.stunum = stunum;
	}
	public String getLearnGuide() {
		return learnGuide;
	}
	public void setLearnGuide(String learnGuide) {
		this.learnGuide = learnGuide;
	}
	public String getHonour() {
		return honour;
	}
	public void setHonour(String honour) {
		this.honour = honour;
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