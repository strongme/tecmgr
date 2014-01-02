package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkBookWriteBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String time;
     private String name;
     private String role;
     private String publicAndHonour;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPublicAndHonour() {
		return publicAndHonour;
	}
	public void setPublicAndHonour(String publicAndHonour) {
		this.publicAndHonour = publicAndHonour;
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