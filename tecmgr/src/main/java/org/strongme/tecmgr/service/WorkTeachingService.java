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
import org.strongme.tecmgr.bean.WorkTeachingBean;

@Service
public class WorkTeachingService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(WorkTeachingBean bean) {
		final WorkTeachingBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workteaching (teacherid,time,stunum,learnGuide,honour,proff,remark)VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setDate(2, new java.sql.Date(tmp.getTime().getTime()));
				ps.setInt(3, tmp.getStunum());
				ps.setString(4, tmp.getLearnGuide());
				ps.setString(5, tmp.getHonour());
				ps.setString(6, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps,7, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(WorkTeachingBean bean) {
		final WorkTeachingBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workteaching SET time = ?,stunum = ?,learnGuide = ?,honour = ?,proff = ?,remark = ? where id="+bean.getId()+";";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setInt(2, tmp.getStunum());
				ps.setString(3, tmp.getLearnGuide());
				ps.setString(4, tmp.getHonour());
				ps.setString(5, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps,6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}

	public List<WorkTeachingBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,stunum,learnGuide,honour,proff,remark FROM workteaching where teacherid='"+teacherid+"';";
		List<WorkTeachingBean> list = jdbcTemplate.query(sql, new RowMapper<WorkTeachingBean>() {
			public WorkTeachingBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkTeachingBean result = new WorkTeachingBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getDate(3));
				result.setStunum(arg0.getInt(4));
				result.setLearnGuide(arg0.getString(5));
				result.setHonour(arg0.getString(6));
				result.setProff(arg0.getString(7));
				try {
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0, 8),"UTF-8"));
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
