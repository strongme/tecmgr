package org.strongme.tecmgr.bean;



/**
 * @author walter
 *
 */
public class SectionSummaryBean  implements java.io.Serializable {

     private Integer id;
     private String teacherId;
     private String timeZone;
     private String growPlan;
     private String selfCheckRealized;
     private String selfCheckUnrealized;
     private String goalRevise;
     private String remark;
     private SectionLittleSummaryBean sl1;
     private SectionLittleSummaryBean sl2;
     private SectionLittleSummaryBean sl3;

    // Constructors

    /** default constructor */
    public SectionSummaryBean() {
    }

	/** minimal constructor */
    public SectionSummaryBean(String teacherId) {
        this.teacherId = teacherId;
    }
    
    /** full constructor */
    public SectionSummaryBean(String teacherId, String timeZone, String growPlan, String selfCheckRealized, String selfCheckUnrealized, String goalRevise, String remark) {
        this.teacherId = teacherId;
        this.timeZone = timeZone;
        this.growPlan = growPlan;
        this.selfCheckRealized = selfCheckRealized;
        this.selfCheckUnrealized = selfCheckUnrealized;
        this.goalRevise = goalRevise;
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
    

    public String getTimeZone() {
        return this.timeZone;
    }
    
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    

    public String getGrowPlan() {
        return this.growPlan;
    }
    
    public void setGrowPlan(String growPlan) {
        this.growPlan = growPlan;
    }
    

    public String getSelfCheckRealized() {
        return this.selfCheckRealized;
    }
    
    public void setSelfCheckRealized(String selfCheckRealized) {
        this.selfCheckRealized = selfCheckRealized;
    }
    

    public String getSelfCheckUnrealized() {
        return this.selfCheckUnrealized;
    }
    
    public void setSelfCheckUnrealized(String selfCheckUnrealized) {
        this.selfCheckUnrealized = selfCheckUnrealized;
    }
    

    public String getGoalRevise() {
        return this.goalRevise;
    }
    
    public void setGoalRevise(String goalRevise) {
        this.goalRevise = goalRevise;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public SectionLittleSummaryBean getSl1() {
		return sl1;
	}

	public void setSl1(SectionLittleSummaryBean sl1) {
		this.sl1 = sl1;
	}

	public SectionLittleSummaryBean getSl2() {
		return sl2;
	}

	public void setSl2(SectionLittleSummaryBean sl2) {
		this.sl2 = sl2;
	}

	public SectionLittleSummaryBean getSl3() {
		return sl3;
	}

	public void setSl3(SectionLittleSummaryBean sl3) {
		this.sl3 = sl3;
	}
   








}