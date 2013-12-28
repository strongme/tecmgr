package org.strongme.tecmgr.bean;



public class PlanDetailsBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherId;
     private String proTechQua;
     private String proWorkGoal;
     private String remark;


    // Constructors

    /** default constructor */
    public PlanDetailsBean() {
    }

	/** minimal constructor */
    public PlanDetailsBean(String teacherId) {
        this.teacherId = teacherId;
    }
    
    /** full constructor */
    public PlanDetailsBean(String teacherId, String proTechQua, String proWorkGoal, String remark) {
        this.teacherId = teacherId;
        this.proTechQua = proTechQua;
        this.proWorkGoal = proWorkGoal;
        this.remark = remark;
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
    

    public String getProTechQua() {
        return this.proTechQua;
    }
    
    public void setProTechQua(String proTechQua) {
        this.proTechQua = proTechQua;
    }
    

    public String getProWorkGoal() {
        return this.proWorkGoal;
    }
    
    public void setProWorkGoal(String proWorkGoal) {
        this.proWorkGoal = proWorkGoal;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}