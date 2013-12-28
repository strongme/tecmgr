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
import org.strongme.tecmgr.bean.SectionSummaryBean;

@Service
public class SectionSummaryService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;

	public Integer save(SectionSummaryBean bean) {
		final SectionSummaryBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO sectionsummary (teacherId,timeZone,growPlan,selfCheckRealized,selfCheckUnrealized,goalRevise,remark) VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherId());
				ps.setString(2, tmp.getTimeZone());
				try {
					lc.setBlobAsBytes(ps, 3, tmp.getGrowPlan().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getSelfCheckRealized().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getSelfCheckUnrealized().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getGoalRevise().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 7, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(SectionSummaryBean bean) {
		final SectionSummaryBean tmp = bean;
		int result = -1;
		String sql = "UPDATE sectionsummary SET timeZone = ?,growPlan = ?,selfCheckRealized = ?,selfCheckUnrealized = ?,goalRevise = ?,remark = ? where teacherid='"+bean.getTeacherId()+"';";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTimeZone());
				try {
					lc.setBlobAsBytes(ps, 2, tmp.getGrowPlan().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 3, tmp.getSelfCheckRealized().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getSelfCheckUnrealized().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getGoalRevise().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	public SectionSummaryBean get(String teacherid) {
		SectionSummaryBean result = new SectionSummaryBean();
		String sql = "SELECT id,teacherId,timeZone,growPlan,selfCheckRealized,selfCheckUnrealized,goalRevise,remark FROM sectionsummary  where teacherId='"+teacherid+"'";
		List<SectionSummaryBean> list = jdbcTemplate.query(sql, new RowMapper<SectionSummaryBean>() {
			public SectionSummaryBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				SectionSummaryBean result = new SectionSummaryBean();
				result.setId(arg0.getInt(1));
				result.setTeacherId(arg0.getString(2));
				result.setTimeZone(arg0.getString(3));
				try {
					result.setGrowPlan(new String(lobHandler.getBlobAsBytes(arg0, 4),"UTF-8"));
					result.setSelfCheckRealized(new String(lobHandler.getBlobAsBytes(arg0, 5),"UTF-8"));
					result.setSelfCheckUnrealized(new String(lobHandler.getBlobAsBytes(arg0, 6),"UTF-8"));
					result.setGoalRevise(new String(lobHandler.getBlobAsBytes(arg0, 7),"UTF-8"));
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
		String sql = "select count(1) from sectionsummary where teacherid='"+id+"'";
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}
	

}
