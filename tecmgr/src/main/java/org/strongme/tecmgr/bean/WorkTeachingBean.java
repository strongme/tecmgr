package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkTeachingBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private Integer stunum;
     private String learnGuide;
     private String honour;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkTeachingBean() {
    }

	/** minimal constructor */
    public WorkTeachingBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkTeachingBean(String teacherid, Date time, Integer stunum, String learnGuide, String honour, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.stunum = stunum;
        this.learnGuide = learnGuide;
        this.honour = honour;
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
    

    public Integer getStunum() {
        return this.stunum;
    }
    
    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }
    

    public String getLearnGuide() {
        return this.learnGuide;
    }
    
    public void setLearnGuide(String learnGuide) {
        this.learnGuide = learnGuide;
    }
    

    public String getHonour() {
        return this.honour;
    }
    
    public void setHonour(String honour) {
        this.honour = honour;
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