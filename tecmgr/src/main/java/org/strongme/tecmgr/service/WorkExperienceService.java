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
import org.strongme.tecmgr.bean.WorkExperienceBean;

@Service
public class WorkExperienceService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(WorkExperienceBean bean) {
		final WorkExperienceBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workexperience (teacherid,startTime,endTime,uintOrDepartment,postOrProtitle,remark3) VALUES(?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setString(2, tmp.getStartTime());
				ps.setString(3, tmp.getEndTime());
				ps.setString(4, tmp.getUintOrDepartment());
				ps.setString(5, tmp.getPostOrProtitle());
				try {
					lc.setBlobAsBytes(ps, 6, tmp.getRemark3().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(WorkExperienceBean bean) {
		final WorkExperienceBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workexperience SET startTime = ?,endTime = ?,uintOrDepartment = ?,postOrProtitle = ?,remark3 = ?WHERE id="+bean.getId()+";";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getStartTime());
				ps.setString(2,tmp.getEndTime());
				ps.setString(3, tmp.getUintOrDepartment());
				ps.setString(4, tmp.getPostOrProtitle());
				try {
					lc.setBlobAsBytes(ps, 5, tmp.getRemark3().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}

	public List<WorkExperienceBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,startTime,endTime,uintOrDepartment,postOrProtitle,remark3 FROM workexperience where teacherid = '"+teacherid+"';";
		List<WorkExperienceBean> list = jdbcTemplate.query(sql, new RowMapper<WorkExperienceBean>() {
			public WorkExperienceBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkExperienceBean result = new WorkExperienceBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setStartTime(arg0.getString(3));
				result.setEndTime(arg0.getString(4));
				result.setUintOrDepartment(arg0.getString(5));
				result.setPostOrProtitle(arg0.getString(6));
				try {
					result.setRemark3(new String(lobHandler.getBlobAsBytes(arg0, 7),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}
		});
		return list;
	}
	
	
}
