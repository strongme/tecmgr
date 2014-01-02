package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkProMoralBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String time;
     private Integer famEdu;
     private Integer phyPunishiment;
     private Integer financialRelation;
     private Integer reference;
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
	public Integer getFamEdu() {
		return famEdu;
	}
	public void setFamEdu(Integer famEdu) {
		this.famEdu = famEdu;
	}
	public Integer getPhyPunishiment() {
		return phyPunishiment;
	}
	public void setPhyPunishiment(Integer phyPunishiment) {
		this.phyPunishiment = phyPunishiment;
	}
	public Integer getFinancialRelation() {
		return financialRelation;
	}
	public void setFinancialRelation(Integer financialRelation) {
		this.financialRelation = financialRelation;
	}
	public Integer getReference() {
		return reference;
	}
	public void setReference(Integer reference) {
		this.reference = reference;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


     







}