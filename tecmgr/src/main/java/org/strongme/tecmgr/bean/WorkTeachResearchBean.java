package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkTeachResearchBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String name;
     private String org;
     private String role;
     private String finishedDetails;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkTeachResearchBean() {
    }

	/** minimal constructor */
    public WorkTeachResearchBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkTeachResearchBean(String teacherid, Date time, String name, String org, String role, String finishedDetails, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.name = name;
        this.org = org;
        this.role = role;
        this.finishedDetails = finishedDetails;
        this.proff = proff;
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
    

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    

    public String getOrg() {
        return this.org;
    }
    
    public void setOrg(String org) {
        this.org = org;
    }
    

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    

    public String getFinishedDetails() {
        return this.finishedDetails;
    }
    
    public void setFinishedDetails(String finishedDetails) {
        this.finishedDetails = finishedDetails;
    }
    

    public String getProff() {
        return this.proff;
    }
    
    public void setProff(String proff) {
        this.proff = proff;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}