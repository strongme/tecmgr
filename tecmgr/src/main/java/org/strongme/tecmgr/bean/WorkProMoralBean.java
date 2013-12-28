package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkProMoralBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private Integer famEdu;
     private Integer phyPunishiment;
     private Integer financialRelation;
     private Integer reference;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkProMoralBean() {
    }

	/** minimal constructor */
    public WorkProMoralBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkProMoralBean(String teacherid, Date time, Integer famEdu, Integer phyPunishiment, Integer financialRelation, Integer reference, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.famEdu = famEdu;
        this.phyPunishiment = phyPunishiment;
        this.financialRelation = financialRelation;
        this.reference = reference;
        this.remark = remark;
    }

   

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getTeacherid() {
        return this.teacherid;
    }
    
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    

    public Integer getFamEdu() {
        return this.famEdu;
    }
    
    public void setFamEdu(Integer famEdu) {
        this.famEdu = famEdu;
    }

    public Integer getPhyPunishiment() {
        return this.phyPunishiment;
    }
    
    public void setPhyPunishiment(Integer phyPunishiment) {
        this.phyPunishiment = phyPunishiment;
    }
    

    public Integer getFinancialRelation() {
        return this.financialRelation;
    }
    
    public void setFinancialRelation(Integer financialRelation) {
        this.financialRelation = financialRelation;
    }
    

    public Integer getReference() {
        return this.reference;
    }
    
    public void setReference(Integer reference) {
        this.reference = reference;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}