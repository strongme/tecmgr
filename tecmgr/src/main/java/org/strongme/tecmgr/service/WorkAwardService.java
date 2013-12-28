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
import org.strongme.tecmgr.bean.WorkAwardBean;

@Service
public class WorkAwardService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	//1:N
	//保存方法
	public Integer save(WorkAwardBean bean) {
		final WorkAwardBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workaward (teacherid,name,time,award,org,proff,remark) VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setString(2, tmp.getName());
				ps.setDate(3, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(4, tmp.getAward());
				ps.setString(5, tmp.getOrg());
				ps.setString(6, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps, 7, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	//更新
	public Integer update(WorkAwardBean bean) {
		final WorkAwardBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workaward SET time = ?,name=?,award = ?,org = ?,proff = ?,remark = ? WHERE id="+bean.getId();
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(2, tmp.getName());
				ps.setString(3, tmp.getAward());
				ps.setString(4, tmp.getOrg());
				ps.setString(5, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps,6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public List<WorkAwardBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,name,time,award,org,proff,remark FROM workaward where teacherid='"+teacherid+"';";
		List<WorkAwardBean> list = jdbcTemplate.query(sql, new RowMapper<WorkAwardBean>() {
			public WorkAwardBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkAwardBean result = new WorkAwardBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setName(arg0.getString(3));
				result.setTime(arg0.getDate(4));
				result.setAward(arg0.getString(5));
				result.setOrg(arg0.getString(6));
				result.setProff(arg0.getString(7));
				try {
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0,8),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return result;
			}
		});
		return list;
	}

}
