package org.strongme.tecmgr.bean;
import java.util.Date;


public class WorkAwardBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherid;
     private String name;
     private Date time;
     private String award;
     private String org;
     private String proff;
     private String remark;


    // Constructors

    /** default constructor */
    public WorkAwardBean() {
    }

	/** minimal constructor */
    public WorkAwardBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    public WorkAwardBean(Integer id, String teacherid, String name, Date time,
			String award, String org, String proff, String remark) {
		super();
		this.id = id;
		this.teacherid = teacherid;
		this.name = name;
		this.time = time;
		this.award = award;
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
    

    public String getAward() {
        return this.award;
    }
    
    public void setAward(String award) {
        this.award = award;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   








}