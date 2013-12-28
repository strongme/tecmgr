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
import org.strongme.tecmgr.bean.WorkCommSupportBean;

@Service
public class WorkCommSupportService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(WorkCommSupportBean bean) {
		final WorkCommSupportBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workcommsupport(teacherid,time,originalSch,exchang,proff,remark) VALUES(?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setDate(2, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(3, tmp.getOriginalSch());
				ps.setString(4, tmp.getExchang());
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
	
	public Integer update(WorkCommSupportBean bean) {
		final WorkCommSupportBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workcommsupport SET time = ?,originalSch = ?,exchang = ?,proff = ?,remark = ? where id="+bean.getId()+";";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(2, tmp.getOriginalSch());
				ps.setString(3, tmp.getExchang());
				ps.setString(4, tmp.getProff());
				try {
					lc.setBlobAsBytes(ps,5, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}

	public List<WorkCommSupportBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,originalSch,exchang,proff,remark FROM workcommsupport where teacherid='"+teacherid+"';";
		List<WorkCommSupportBean> list = jdbcTemplate.query(sql, new RowMapper<WorkCommSupportBean>() {
			public WorkCommSupportBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkCommSupportBean result = new WorkCommSupportBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getDate(3));
				result.setOriginalSch(arg0.getString(4));
				result.setExchang(arg0.getString(5));
				result.setProff(arg0.getString(6));
				try {
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0, 7),"UTF-8"));
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
