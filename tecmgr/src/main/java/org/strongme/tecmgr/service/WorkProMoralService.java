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
import org.strongme.tecmgr.bean.WorkProMoralBean;

@Service
public class WorkProMoralService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(WorkProMoralBean bean) {
		final WorkProMoralBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO workpromoral(teacherid,time,famEdu,phyPunishiment,financialRelation,reference,remark) VALUES(?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setString(2, tmp.getTime());
				ps.setInt(3, tmp.getFamEdu());
				ps.setInt(4, tmp.getPhyPunishiment());
				ps.setInt(5, tmp.getFinancialRelation());
				ps.setInt(6, tmp.getReference());
				try {
					lc.setBlobAsBytes(ps,7, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(WorkProMoralBean bean) {
		final WorkProMoralBean tmp = bean;
		int result = -1;
		String sql = "UPDATE workpromoral SET time = ?,famEdu = ?,phyPunishiment = ?,financialRelation = ?,reference = ?,remark = ? where id="+bean.getId()+";";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1,tmp.getTime());
				ps.setInt(2, tmp.getFamEdu());
				ps.setInt(3, tmp.getPhyPunishiment());
				ps.setInt(4, tmp.getFinancialRelation());
				ps.setInt(5, tmp.getReference());
				try {
					lc.setBlobAsBytes(ps,6, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		return result;
	}

	public List<WorkProMoralBean> get(String teacherid) {
		String sql = "SELECT id,teacherid,time,famEdu,phyPunishiment,financialRelation,reference,remark FROM workpromoral where teacherid='"+teacherid+"';";
		List<WorkProMoralBean> list = jdbcTemplate.query(sql, new RowMapper<WorkProMoralBean>() {
			public WorkProMoralBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				WorkProMoralBean result = new WorkProMoralBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setTime(arg0.getString(3));
				result.setFamEdu(arg0.getInt(4));
				result.setPhyPunishiment(arg0.getInt(5));
				result.setFinancialRelation(arg0.getInt(6));
				result.setReference(arg0.getInt(7));
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
