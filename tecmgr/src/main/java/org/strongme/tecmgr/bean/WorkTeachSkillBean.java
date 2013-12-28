package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkTeachSkillBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String class_;
     private String form;
     private String score;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkTeachSkillBean() {
    }

	/** minimal constructor */
    public WorkTeachSkillBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkTeachSkillBean(String teacherid, Date time, String class_, String form, String score, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.class_ = class_;
        this.form = form;
        this.score = score;
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
    

    public String getClass_() {
        return this.class_;
    }
    
    public void setClass_(String class_) {
        this.class_ = class_;
    }
    

    public String getForm() {
        return this.form;
    }
    
    public void setForm(String form) {
        this.form = form;
    }
    

    public String getScore() {
        return this.score;
    }
    
    public void setScore(String score) {
        this.score = score;
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