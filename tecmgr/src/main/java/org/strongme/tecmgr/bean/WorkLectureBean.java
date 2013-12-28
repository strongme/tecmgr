package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkLectureBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String name;
     private String range;
     private String org;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkLectureBean() {
    }

	/** minimal constructor */
    public WorkLectureBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkLectureBean(String teacherid, Date time, String name, String range, String org, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.name = name;
        this.range = range;
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
    

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    

    public String getRange() {
        return this.range;
    }
    
    public void setRange(String range) {
        this.range = range;
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