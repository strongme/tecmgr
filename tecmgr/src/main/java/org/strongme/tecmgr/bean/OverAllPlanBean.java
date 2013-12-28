package org.strongme.tecmgr.bean;

import java.util.Date;



public class OverAllPlanBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherId;
     private Date planTime;
     private String eduIdea;
     private String advanced;
     private String disadvanced;
     private String remark;
     private String planDetail;
     


    // Constructors

    /** default constructor */
    public OverAllPlanBean() {
    }

	/** minimal constructor */
    public OverAllPlanBean(String teacherId) {
        this.teacherId = teacherId;
    }
    
   
    public String getPlanDetail() {
		return planDetail;
	}

	public void setPlanDetail(String planDetail) {
		this.planDetail = planDetail;
	}

	public OverAllPlanBean(Integer id, String teacherId, Date planTime,
			String eduIdea, String advanced, String disadvanced, String remark,
			String planDetail) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.planTime = planTime;
		this.eduIdea = eduIdea;
		this.advanced = advanced;
		this.disadvanced = disadvanced;
		this.remark = remark;
		this.planDetail = planDetail;
	}

	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Date getPlanTime() {
        return this.planTime;
    }
    
    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }
    

    public String getEduIdea() {
        return this.eduIdea;
    }
    
    public void setEduIdea(String eduIdea) {
        this.eduIdea = eduIdea;
    }
    

    public String getAdvanced() {
        return this.advanced;
    }
    
    public void setAdvanced(String advanced) {
        this.advanced = advanced;
    }
    

    public String getDisadvanced() {
        return this.disadvanced;
    }
    
    public void setDisadvanced(String disadvanced) {
        this.disadvanced = disadvanced;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}