package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkSurveyBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String jobDetails;
     private String org;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkSurveyBean() {
    }

	/** minimal constructor */
    public WorkSurveyBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkSurveyBean(String teacherid, Date time, String jobDetails, String org, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.jobDetails = jobDetails;
        this.org = org;
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
    

    public String getJobDetails() {
        return this.jobDetails;
    }
    
    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }
    

    public String getOrg() {
        return this.org;
    }
    
    public void setOrg(String org) {
        this.org = org;
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