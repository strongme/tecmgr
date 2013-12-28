package org.strongme.tecmgr.bean;
import java.util.Date;



public class WorkBookWriteBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private Date time;
     private String name;
     private String role;
     private String publicAndHonour;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkBookWriteBean() {
    }

	/** minimal constructor */
    public WorkBookWriteBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public WorkBookWriteBean(String teacherid, Date time, String name, String role, String publicAndHonour, String proff, String remark) {
        this.teacherid = teacherid;
        this.time = time;
        this.name = name;
        this.role = role;
        this.publicAndHonour = publicAndHonour;
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
    

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    

    public String getPublicAndHonour() {
        return this.publicAndHonour;
    }
    
    public void setPublicAndHonour(String publicAndHonour) {
        this.publicAndHonour = publicAndHonour;
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