package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkExperienceBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date startTime;
     private Date endTime;
     private String uintOrDepartment;
     private String postOrProtitle;
     private String remark3;


    // Constructors

    /** default constructor */
    public WorkExperienceBean() {
    }

	/** minimal constructor */
    public WorkExperienceBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkExperienceBean(String teacherid, Date startTime, Date endTime, String uintOrDepartment, String postOrProtitle, String remark3) {
        this.teacherid = teacherid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.uintOrDepartment = uintOrDepartment;
        this.postOrProtitle = postOrProtitle;
        this.remark3 = remark3;
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

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    

    public String getUintOrDepartment() {
        return this.uintOrDepartment;
    }
    
    public void setUintOrDepartment(String uintOrDepartment) {
        this.uintOrDepartment = uintOrDepartment;
    }
    

    public String getPostOrProtitle() {
        return this.postOrProtitle;
    }
    
    public void setPostOrProtitle(String postOrProtitle) {
        this.postOrProtitle = postOrProtitle;
    }
    

    public String getRemark3() {
        return this.remark3;
    }
    
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
   








}