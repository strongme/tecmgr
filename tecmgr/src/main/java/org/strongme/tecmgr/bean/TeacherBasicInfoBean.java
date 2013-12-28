package org.strongme.tecmgr.bean;
import java.util.Date;

public class TeacherBasicInfoBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String teacherId;
     private Integer gender;
     private String native_;
     private Date birth;
     private String nation;
     private String politicsStatus;
     private String subject;
     private String highestDegree;
     private String professionalTitle;
     private String position;
     private String phone;
     private String email;
     private String qq;
     private String departmentName;
     private String talent;
     private String photo;
     private String remark2;


    // Constructors

    /** default constructor */
    public TeacherBasicInfoBean() {
    }

	/** minimal constructor */
    public TeacherBasicInfoBean(String teacherId) {
        this.teacherId = teacherId;
    }
    
    /** full constructor */
    public TeacherBasicInfoBean(String teacherId, Integer gender, String native_, Date birth, String nation, String politicsStatus, String subject, String highestDegree, String professionalTitle, String position, String phone, String email, String qq, String departmentName, String talent, String photo, String remark2) {
        this.teacherId = teacherId;
        this.gender = gender;
        this.native_ = native_;
        this.birth = birth;
        this.nation = nation;
        this.politicsStatus = politicsStatus;
        this.subject = subject;
        this.highestDegree = highestDegree;
        this.professionalTitle = professionalTitle;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.qq = qq;
        this.departmentName = departmentName;
        this.talent = talent;
        this.photo = photo;
        this.remark2 = remark2;
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
    

    public Integer getGender() {
        return this.gender;
    }
    
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    

    public String getNative_() {
        return this.native_;
    }
    
    public void setNative_(String native_) {
        this.native_ = native_;
    }

    public Date getBirth() {
        return this.birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    

    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    

    public String getPoliticsStatus() {
        return this.politicsStatus;
    }
    
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
    

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    

    public String getHighestDegree() {
        return this.highestDegree;
    }
    
    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }
    

    public String getProfessionalTitle() {
        return this.professionalTitle;
    }
    
    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }
    

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    

    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    

    public String getTalent() {
        return this.talent;
    }
    
    public void setTalent(String talent) {
        this.talent = talent;
    }
    

    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
   








}