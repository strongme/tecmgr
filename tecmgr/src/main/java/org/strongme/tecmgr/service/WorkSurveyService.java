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
import org.strongme.tecmgr.bean.WorkSurveyBean;

@Service
public class WorkSurveyService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	//1:N
	//保存方法
	public Integer save(WorkSurveyBean bean) {
		final WorkSurveyBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO worksurvey (teacherid,time,jobDetails,org,proff,remark)VALUES(?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setDate(2, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(3, tmp.getJobDetails());
				ps.setString(4, tmp.getOrg());
				ps.setString(5, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps, 6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	//更新
	public Integer update(WorkSurveyBean bean) {
		final WorkSurveyBean tmp = bean;
		int result = -1;
		String sql = "UPDATE worksurvey SET time = ?,jobDetails = ?,org = ?,proff = ?,remark = ? WHERE id="+bean.getId();
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(2, tmp.getJobDetails());
				ps.setString(3, tmp.getOrg());
				ps.setString(4, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps, 5, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public List<WorkSurveyBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,jobDetails,org,proff,remark FROM worksurvey where teacherid='"+teacherid+"';";
		List<WorkSurveyBean> list = jdbcTemplate.query(sql, new RowMapper<WorkSurveyBean>() {
			public WorkSurveyBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkSurveyBean result = new WorkSurveyBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getDate(3));
				result.setJobDetails(arg0.getString(4));
				result.setOrg(arg0.getString(5));
				result.setProff(arg0.getString(6));
				try {
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0,7),"UTF-8"));
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
