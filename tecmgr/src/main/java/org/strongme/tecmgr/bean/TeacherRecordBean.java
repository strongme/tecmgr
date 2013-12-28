package org.strongme.tecmgr.bean;
import java.util.Date;



public class TeacherRecordBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherId;
     private String departmentName;
     private String teacherName;
     private Date createProfileTime;
     private Date recentModifyTime;
     private String password;


    // Constructors

    /** default constructor */
    public TeacherRecordBean() {
    }

	/** minimal constructor */
    public TeacherRecordBean(String teacherId) {
        this.teacherId = teacherId;
    }
    
    /** full constructor */
    

   

    public Integer getId() {
        return this.id;
    }
    
    public TeacherRecordBean(Integer id, String teacherId,
			String departmentName, String teacherName, String password) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.departmentName = departmentName;
		this.teacherName = teacherName;
		this.password = password;
	}

	public TeacherRecordBean(String teacherId, String departmentName,
			String teacherName, String password) {
		super();
		this.teacherId = teacherId;
		this.departmentName = departmentName;
		this.teacherName = teacherName;
		this.password = password;
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
    

    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    

    public String getTeacherName() {
        return this.teacherName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getCreateProfileTime() {
        return this.createProfileTime;
    }
    
    public void setCreateProfileTime(Date createProfileTime) {
        this.createProfileTime = createProfileTime;
    }

    public Date getRecentModifyTime() {
        return this.recentModifyTime;
    }
    
    public void setRecentModifyTime(Date recentModifyTime) {
        this.recentModifyTime = recentModifyTime;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   








}