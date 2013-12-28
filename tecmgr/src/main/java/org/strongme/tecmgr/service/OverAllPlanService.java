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
import org.strongme.tecmgr.bean.OverAllPlanBean;

@Service
public class OverAllPlanService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(OverAllPlanBean bean) {
		final OverAllPlanBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO overallplan(teacherId,planTime,eduIdea,advanced,disadvanced,plandetail,remark) VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherId());
				ps.setDate(2, new java.sql.Date(tmp.getPlanTime().getTime()));
				try {
					lc.setBlobAsBytes(ps, 3, tmp.getEduIdea().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getAdvanced().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getDisadvanced().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getPlanDetail().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 7, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(OverAllPlanBean bean) {
		final OverAllPlanBean tmp = bean;
		int result = -1;
		String sql = "UPDATE overallplan SET planTime = ?,eduIdea = ?,advanced = ?,disadvanced = ?,plandetail=?,remark = ? WHERE teacherid = '"+bean.getTeacherId()+"';";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getPlanTime().getTime()));
				try {
					lc.setBlobAsBytes(ps, 2, tmp.getEduIdea().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 3, tmp.getAdvanced().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getDisadvanced().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getPlanDetail().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	public OverAllPlanBean get(String teacherid) {
		OverAllPlanBean result = new OverAllPlanBean();
		String sql = "SELECT id,teacherId,planTime,eduIdea,advanced,disadvanced,plandetail,remark FROM overallplan where teacherId='"+teacherid+"';";
		List<OverAllPlanBean> list = jdbcTemplate.query(sql, new RowMapper<OverAllPlanBean>() {
			public OverAllPlanBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				OverAllPlanBean result = new OverAllPlanBean();
				result.setId(arg0.getInt(1));
				result.setTeacherId(arg0.getString(2));
				result.setPlanTime(arg0.getDate(3));
				try {
					result.setEduIdea(new String(lobHandler.getBlobAsBytes(arg0, 4),"UTF-8"));
					result.setAdvanced(new String(lobHandler.getBlobAsBytes(arg0, 5),"UTF-8"));
					result.setDisadvanced(new String(lobHandler.getBlobAsBytes(arg0, 6),"UTF-8"));
					result.setPlanDetail(new String(lobHandler.getBlobAsBytes(arg0, 7),"UTF-8"));
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0, 8),"UTF-8"));
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
		String sql = "select count(1) from overallplan where teacherid='"+id+"'";
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}

}
