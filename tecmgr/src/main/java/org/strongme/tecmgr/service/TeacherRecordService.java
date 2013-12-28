package org.strongme.tecmgr.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.strongme.tecmgr.bean.TeacherRecordBean;

@Service
public class TeacherRecordService {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Integer save(TeacherRecordBean bean) {
		int result = -1;
		String sql = "insert into teacherrecord(teacherid,password,departmentname,teachername,createprofiletime,recentmodifytime) values('"+bean.getTeacherId()+"','"+bean.getPassword()+"','"+bean.getDepartmentName()+"','"+bean.getTeacherName()+"',sysdate(),sysdate())";
		result = jdbcTemplate.update(sql);
		return result;
	}
	
	public TeacherRecordBean get(String teacherid) {
		String sql = "select id,teacherid,password,teachername,departmentname,createprofiletime,recentmodifytime from teacherrecord where teacherid='"+teacherid+"'";
		List<TeacherRecordBean> list = jdbcTemplate.query(sql, new RowMapper<TeacherRecordBean>() {
			public TeacherRecordBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				TeacherRecordBean result = new TeacherRecordBean();
				result.setId(arg0.getInt(1));
				result.setTeacherId(arg0.getString(2));
				result.setPassword(arg0.getString(3));
				result.setTeacherName(arg0.getString(4));
				result.setDepartmentName(arg0.getString(5));
				result.setCreateProfileTime(arg0.getDate(6));
				result.setRecentModifyTime(arg0.getDate(7));
				return result;
			}
		});
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public boolean isExist(String id) {
		boolean result = false;
		String sql = "select count(1) from teacherrecord where teacherid='"+id+"'";
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}
	
	public List<TeacherRecordBean> doquery(String zzmm,String subject,String degree,String title,String department,String name,String teacherid) {
		String sql = "select a.id,a.teacherid,a.password,a.teachername,a.departmentname,a.createprofiletime,a.recentmodifytime from teacherrecord a,teacherbasicinfo b where a.teacherid=b.teacherid";
		String sub = "";
		if(zzmm!=null&&!"".equals(zzmm)) {sub += " and b.politicsStatus like '%"+zzmm+"%'";}
		if(subject!=null&&!"".equals(subject)) {sub += " and b.subject like '%"+subject+"%'";}
		if(title!=null&&!"".equals(title)) {sub+= " and b.professionalTitle like '%"+title+"%'";}
		if(degree!=null&&!"".equals(degree)) {sub+= " and b.highestDegree like '%"+degree+"%'";}
		if(department!=null&&!"".equals(department)) {sub+= " and a.departmentName like '%"+department+"%'";}
		if(name!=null&&!"".equals(name)) {sub+= " and a.teachername like '%"+name+"%'";}
		if(teacherid!=null&&!"".equals(teacherid)) {sub+= " and a.teacherid = '"+teacherid+"'";}
		sql += sub;
		List<TeacherRecordBean> list = jdbcTemplate.query(sql, new RowMapper<TeacherRecordBean>() {
			public TeacherRecordBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				TeacherRecordBean result = new TeacherRecordBean();
				result.setId(arg0.getInt(1));
				result.setTeacherId(arg0.getString(2));
				result.setPassword(arg0.getString(3));
				result.setTeacherName(arg0.getString(4));
				result.setDepartmentName(arg0.getString(5));
				result.setCreateProfileTime(arg0.getDate(6));
				result.setRecentModifyTime(arg0.getDate(7));
				return result;
			}
		});
		return list;
	}
	
}

