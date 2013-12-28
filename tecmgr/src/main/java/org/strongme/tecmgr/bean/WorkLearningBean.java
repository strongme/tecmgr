package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkLearningBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String name;
     private String guideInfo;
     private String award;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkLearningBean() {
    }

	/** minimal constructor */
    public WorkLearningBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkLearningBean(String teacherid, Date time, String name, String guideInfo, String award, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.name = name;
        this.guideInfo = guideInfo;
        this.award = award;
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
    

    public String getGuideInfo() {
        return this.guideInfo;
    }
    
    public void setGuideInfo(String guideInfo) {
        this.guideInfo = guideInfo;
    }
    

    public String getAward() {
        return this.award;
    }
    
    public void setAward(String award) {
        this.award = award;
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