package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkContinueLearnBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String contentAndScore;
     private String org;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkContinueLearnBean() {
    }

	/** minimal constructor */
    public WorkContinueLearnBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkContinueLearnBean(String teacherid, Date time, String contentAndScore, String org, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.contentAndScore = contentAndScore;
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
    

    public String getContentAndScore() {
        return this.contentAndScore;
    }
    
    public void setContentAndScore(String contentAndScore) {
        this.contentAndScore = contentAndScore;
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