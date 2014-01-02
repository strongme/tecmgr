package org.strongme.tecmgr.bean;

import java.util.Date;


public class HonourBean  implements java.io.Serializable {

     private Integer id;
     private String teacherid;
     private String honourTime;
     private String honourDetail;
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
	public String getHonourTime() {
		return honourTime;
	}
	public void setHonourTime(String honourTime) {
		this.honourTime = honourTime;
	}
	public String getHonourDetail() {
		return honourDetail;
	}
	public void setHonourDetail(String honourDetail) {
		this.honourDetail = honourDetail;
	}


}