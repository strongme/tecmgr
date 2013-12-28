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
import org.strongme.tecmgr.bean.HonourBean;

@Service
public class HonourService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(HonourBean bean) {
		final HonourBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO honour(teacherid,honourDetail) VALUES(?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				try {
					lc.setBlobAsBytes(ps, 2, tmp.getHonourDetail().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(HonourBean bean) {
		final HonourBean tmp = bean;
		int result = -1;
		String sql = "UPDATE honour SET honourDetail= ? WHERE teacherid='"+bean.getTeacherid()+"';";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				try {
					lc.setBlobAsBytes(ps, 1, tmp.getHonourDetail().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	public HonourBean get(String teacherid) {
		HonourBean result = new HonourBean();
		String sql = "SELECT id,teacherid,honourDetail FROM honour  where teacherId='"+teacherid+"'";
		List<HonourBean> list = jdbcTemplate.query(sql, new RowMapper<HonourBean>() {
			public HonourBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				HonourBean result = new HonourBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				try {
					result.setHonourDetail(new String(lobHandler.getBlobAsBytes(arg0,3),"UTF-8"));
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
		String sql = "select count(1) from honour where teacherid='"+id+"'";
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}

}
