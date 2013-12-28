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
import org.strongme.tecmgr.bean.WorkLearningBean;

@Service
public class WorkLearningService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(WorkLearningBean bean) {
		final WorkLearningBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO worklearning (teacherid,time,name,guideInfo,award,proff,remark) VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setDate(2, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(3, tmp.getName());
				ps.setString(4, tmp.getGuideInfo());
				ps.setString(5, tmp.getAward());
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
	
	public Integer update(WorkLearningBean bean) {
		final WorkLearningBean tmp = bean;
		int result = -1;
		String sql = "UPDATE worklearning SET time = ?,name = ?,guideInfo = ?,award = ?,proff = ?,remark = ? where id="+bean.getId()+";";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setDate(1, new java.sql.Date(tmp.getTime().getTime()));
				ps.setString(2, tmp.getName());
				ps.setString(3, tmp.getGuideInfo());
				ps.setString(4, tmp.getAward());
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

	public List<WorkLearningBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,name,guideInfo,award,proff,remark FROM worklearning where teacherid='"+teacherid+"';";
		List<WorkLearningBean> list = jdbcTemplate.query(sql, new RowMapper<WorkLearningBean>() {
			public WorkLearningBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkLearningBean result = new WorkLearningBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getDate(3));
				result.setName(arg0.getString(4));
				result.setGuideInfo(arg0.getString(5));
				result.setAward(arg0.getString(6));
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
