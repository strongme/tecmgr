package org.strongme.tecmgr.bean;



public class SectionLittleSummaryBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Integer num;
     private String rethink;
     private String practice;
     private String learnEachOther;
     private String schoolBasedEdu;
     private String reading;
     private String classExperience;
     private String visitHome;
     private String devote;
     private String remark;



    // Constructors

    /** default constructor */
    public SectionLittleSummaryBean() {
    }

	/** minimal constructor */
    public SectionLittleSummaryBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public SectionLittleSummaryBean(String teacherid, Integer num, String rethink, String practice, String learnEachOther, String schoolBasedEdu, String reading, String classExperience, String visitHome, String devote, String remark) {
        this.teacherid = teacherid;
        this.num = num;
        this.rethink = rethink;
        this.practice = practice;
        this.learnEachOther = learnEachOther;
        this.schoolBasedEdu = schoolBasedEdu;
        this.reading = reading;
        this.classExperience = classExperience;
        this.visitHome = visitHome;
        this.devote = devote;
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
    

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    

    public String getRethink() {
        return this.rethink;
    }
    
    public void setRethink(String rethink) {
        this.rethink = rethink;
    }
    

    public String getPractice() {
        return this.practice;
    }
    
    public void setPractice(String practice) {
        this.practice = practice;
    }
    

    public String getLearnEachOther() {
        return this.learnEachOther;
    }
    
    public void setLearnEachOther(String learnEachOther) {
        this.learnEachOther = learnEachOther;
    }
    

    public String getSchoolBasedEdu() {
        return this.schoolBasedEdu;
    }
    
    public void setSchoolBasedEdu(String schoolBasedEdu) {
        this.schoolBasedEdu = schoolBasedEdu;
    }
    

    public String getReading() {
        return this.reading;
    }
    
    public void setReading(String reading) {
        this.reading = reading;
    }
    

    public String getClassExperience() {
        return this.classExperience;
    }
    
    public void setClassExperience(String classExperience) {
        this.classExperience = classExperience;
    }
    

    public String getVisitHome() {
        return this.visitHome;
    }
    
    public void setVisitHome(String visitHome) {
        this.visitHome = visitHome;
    }
    

    public String getDevote() {
        return this.devote;
    }
    
    public void setDevote(String devote) {
        this.devote = devote;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}