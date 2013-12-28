package org.strongme.tecmgr.bean;

import java.util.Date;


public class HonourBean  implements java.io.Serializable {

     private Integer id;
     private String teacherid;
     private Date honourTime;
     private String honourDetail;


    // Constructors

    /** default constructor */
    public HonourBean() {
    }

	/** minimal constructor */
    public HonourBean(String teacherid) {
        this.teacherid = teacherid;
    }
    
    /** full constructor */
    public HonourBean(String teacherid, Date honourTime, String honourDetail) {
        this.teacherid = teacherid;
        this.honourTime = honourTime;
        this.honourDetail = honourDetail;
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

    public Date getHonourTime() {
        return this.honourTime;
    }
    
    public void setHonourTime(Date honourTime) {
        this.honourTime = honourTime;
    }
    

    public String getHonourDetail() {
        return this.honourDetail;
    }
    
    public void setHonourDetail(String honourDetail) {
        this.honourDetail = honourDetail;
    }
   








}