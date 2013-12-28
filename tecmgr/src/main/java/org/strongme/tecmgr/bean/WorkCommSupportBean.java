package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkCommSupportBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String originalSch;
     private String exchang;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkCommSupportBean() {
    }

	/** minimal constructor */
    public WorkCommSupportBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkCommSupportBean(String teacherid, Date time, String originalSch, String exchang, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.originalSch = originalSch;
        this.exchang = exchang;
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
    

    public String getOriginalSch() {
        return this.originalSch;
    }
    
    public void setOriginalSch(String originalSch) {
        this.originalSch = originalSch;
    }
    

    public String getExchang() {
        return this.exchang;
    }
    
    public void setExchang(String exchang) {
        this.exchang = exchang;
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