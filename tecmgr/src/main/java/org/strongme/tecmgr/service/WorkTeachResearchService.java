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
import org.strongme.tecmgr.bean.WorkTeachResearchBean;

@Service
public class WorkTeachResearchService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	//1:N
	//保存方法
	public Integer save(WorkTeachResearchBean bean) {
		final WorkTeachResearchBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workteachresearch (teacherid,time,name,org,role,finishedDetails,proff,remark) VALUES(?,?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setDate(2, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(3, tmp.getName());
				ps.setString(4, tmp.getOrg());
				ps.setString(5, tmp.getRole());
				ps.setString(6, tmp.getFinishedDetails());
				ps.setString(7, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps,8, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	//更新
	public Integer update(WorkTeachResearchBean bean) {
		final WorkTeachResearchBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workteachresearch SET time = ?,name = ?,org = ?,role = ?,finishedDetails = ?,proff = ?,remark = ? where id="+bean.getId();
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(2, tmp.getName());
				ps.setString(3, tmp.getOrg());
				ps.setString(4, tmp.getRole());
				ps.setString(5, tmp.getFinishedDetails());
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
	
	public List<WorkTeachResearchBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,name,org,role,finishedDetails,proff,remark FROM workteachresearch where teacherid='"+teacherid+"';";
		List<WorkTeachResearchBean> list = jdbcTemplate.query(sql, new RowMapper<WorkTeachResearchBean>() {
			public WorkTeachResearchBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkTeachResearchBean result = new WorkTeachResearchBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getDate(3));
				result.setName(arg0.getString(4));
				result.setOrg(arg0.getString(5));
				result.setRole(arg0.getString(6));
				result.setFinishedDetails(arg0.getString(7));
				result.setProff(arg0.getString(8));
				try {
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0, 9),"UTF-8"));
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
