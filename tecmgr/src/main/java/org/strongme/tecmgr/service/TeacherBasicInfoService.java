package org.strongme.tecmgr.service;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Service;
import org.strongme.tecmgr.bean.TeacherBasicInfoBean;

@Service
public class TeacherBasicInfoService {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(TeacherBasicInfoBean bean) {
		final TeacherBasicInfoBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO teacherbasicinfo(teacherId,gender,native,birth,nation,politicsStatus,subject,highestDegree,professionalTitle,position,phone,email,qq,departmentName,talent,photo,remark2) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherId());
				ps.setInt(2, tmp.getGender());
				ps.setString(3, tmp.getNative_());
				ps.setDate(4, new java.sql.Date(tmp.getBirth().getTime()));
				ps.setString(5, tmp.getNation());
				ps.setString(6, tmp.getPoliticsStatus());
				ps.setString(7, tmp.getSubject());
				ps.setString(8, tmp.getHighestDegree());
				ps.setString(9, tmp.getProfessionalTitle());
				ps.setString(10, tmp.getPosition());
				ps.setString(11, tmp.getPhone());
				ps.setString(12, tmp.getEmail());
				ps.setString(13, tmp.getQq());
				ps.setString(14, tmp.getDepartmentName());
				ps.setString(16, tmp.getPhoto());
				try {
					lc.setBlobAsBytes(ps, 15, tmp.getTalent().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 17, tmp.getRemark2().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(TeacherBasicInfoBean bean) {
		final TeacherBasicInfoBean tmp = bean;
		int result = -1;
		String sql = "UPDATE teacherbasicinfo SET gender = ?,native = ?,birth = ?,nation = ?,politicsStatus =?,subject = ?,highestDegree = ?,professionalTitle = ?,position = ?,phone = ?,email = ?,qq = ?,departmentName = ?,talent = ?,photo = ?,remark2 = ? where teacherid='"+bean.getTeacherId()+"'";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setInt(1, tmp.getGender());
				ps.setString(2, tmp.getNative_());
				ps.setDate(3, new java.sql.Date(tmp.getBirth().getTime()));
				ps.setString(4, tmp.getNation());
				ps.setString(5, tmp.getPoliticsStatus());
				ps.setString(6, tmp.getSubject());
				ps.setString(7, tmp.getHighestDegree());
				ps.setString(8, tmp.getProfessionalTitle());
				ps.setString(9, tmp.getPosition());
				ps.setString(10, tmp.getPhone());
				ps.setString(11, tmp.getEmail());
				ps.setString(12, tmp.getQq());
				ps.setString(13, tmp.getDepartmentName());
				ps.setString(15, tmp.getPhoto());
				try {
					lc.setBlobAsBytes(ps, 14, tmp.getTalent().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 16, tmp.getRemark2().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	public TeacherBasicInfoBean get(String teacherid) {
		TeacherBasicInfoBean result = new TeacherBasicInfoBean();
		String sql = "SELECT id,teacherId,gender,native,birth,nation,politicsStatus,subject,highestDegree,professionalTitle,position,phone,email,qq,departmentName,talent,photo,remark2 FROM teacherbasicinfo where teacherId='"+teacherid+"'";
		List<TeacherBasicInfoBean> list = jdbcTemplate.query(sql, new RowMapper<TeacherBasicInfoBean>() {
			public TeacherBasicInfoBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				TeacherBasicInfoBean result = new TeacherBasicInfoBean();
				result.setId(arg0.getInt(1));
				result.setTeacherId(arg0.getString(2));
				result.setGender(arg0.getInt(3));
				result.setNative_(arg0.getString(4));
				result.setBirth(arg0.getDate(5));
				result.setNation(arg0.getString(6));
				result.setPoliticsStatus(arg0.getString(7));
				result.setSubject(arg0.getString(8));
				result.setHighestDegree(arg0.getString(9));
				result.setProfessionalTitle(arg0.getString(10));
				result.setPosition(arg0.getString(11));
				result.setPhone(arg0.getString(12));
				result.setEmail(arg0.getString(13));
				result.setQq(arg0.getString(14));
				result.setDepartmentName(arg0.getString(15));
				result.setPhoto(arg0.getString(17));
				try {
					result.setTalent(new String(lobHandler.getBlobAsBytes(arg0, 16),"UTF-8"));
					result.setRemark2(new String(lobHandler.getBlobAsBytes(arg0, 18),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return result;
			}
		});
		if(list.size()>0)result = list.get(0);
		return result;
	}
	
	public boolean isExist(String id) {
		boolean result = false;
		String sql = "select count(1) from teacherbasicinfo where teacherid='"+id+"'";
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}
}

