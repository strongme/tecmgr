package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkCommSupportBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String time;
     private String originalSch;
     private String exchang;
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
	public String getOriginalSch() {
		return originalSch;
	}
	public void setOriginalSch(String originalSch) {
		this.originalSch = originalSch;
	}
	public String getExchang() {
		return exchang;
	}
	public void setExchang(String exchang) {
		this.exchang = exchang;
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