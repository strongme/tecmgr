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
import org.strongme.tecmgr.bean.SectionLittleSummaryBean;

@Service
public class SectionLittleSummaryService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private LobHandler  lobHandler;
	
	public Integer save(SectionLittleSummaryBean bean) {
		final SectionLittleSummaryBean tmp = bean;
		int result = -1;
		String sql = "INSERT INTO sectionlittlesummary (teacherid,num,rethink,practice,learnEachOther,schoolBasedEdu,reading,classExperience,visitHome,devote,remark) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				ps.setString(1, tmp.getTeacherid());
				ps.setInt(2, tmp.getNum());
				try {
					lc.setBlobAsBytes(ps, 3, tmp.getRethink().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getPractice().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getLearnEachOther().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getSchoolBasedEdu().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 7, tmp.getReading().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 8, tmp.getClassExperience().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 9, tmp.getVisitHome().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 10, tmp.getDevote().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 11, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	
	public Integer update(SectionLittleSummaryBean bean) {
		final SectionLittleSummaryBean tmp = bean;
		int result = -1;
		String sql = "UPDATE sectionlittlesummary SET rethink = ?,practice = ?,learnEachOther = ?,schoolBasedEdu = ?,reading = ?,classExperience = ?,visitHome = ?,devote = ?,remark = ? where teacherid='"+bean.getTeacherid()+"' and num="+bean.getNum();
		result = jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lc)
					throws SQLException, DataAccessException {
				try {
					lc.setBlobAsBytes(ps, 1, tmp.getRethink().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 2, tmp.getPractice().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 3, tmp.getLearnEachOther().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 4, tmp.getSchoolBasedEdu().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 5, tmp.getReading().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 6, tmp.getClassExperience().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 7, tmp.getVisitHome().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 8, tmp.getDevote().getBytes("UTF-8"));
					lc.setBlobAsBytes(ps, 9, tmp.getRemark().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}});
		return result;
	}
	public SectionLittleSummaryBean get(String teacherid,int num) {
		SectionLittleSummaryBean result = new SectionLittleSummaryBean();
		String sql = "SELECT id,teacherid,num,rethink,practice,learnEachOther,schoolBasedEdu,reading,classExperience,visitHome,devote,remark FROM sectionlittlesummary where teacherid='"+teacherid+"' and num="+num;
		List<SectionLittleSummaryBean> list = jdbcTemplate.query(sql, new RowMapper<SectionLittleSummaryBean>() {
			public SectionLittleSummaryBean mapRow(ResultSet arg0, int arg1) throws SQLException {
				SectionLittleSummaryBean result = new SectionLittleSummaryBean();
				result.setId(arg0.getInt(1));
				result.setTeacherid(arg0.getString(2));
				result.setNum(arg0.getInt(3));
				try {
					result.setRethink(new String(lobHandler.getBlobAsBytes(arg0, 4),"UTF-8"));
					result.setPractice(new String(lobHandler.getBlobAsBytes(arg0, 5),"UTF-8"));
					result.setLearnEachOther(new String(lobHandler.getBlobAsBytes(arg0, 6),"UTF-8"));
					result.setSchoolBasedEdu(new String(lobHandler.getBlobAsBytes(arg0, 7),"UTF-8"));
					result.setReading(new String(lobHandler.getBlobAsBytes(arg0, 8),"UTF-8"));
					result.setClassExperience(new String(lobHandler.getBlobAsBytes(arg0, 9),"UTF-8"));
					result.setVisitHome(new String(lobHandler.getBlobAsBytes(arg0, 10),"UTF-8"));
					result.setDevote(new String(lobHandler.getBlobAsBytes(arg0, 11),"UTF-8"));
					result.setRemark(new String(lobHandler.getBlobAsBytes(arg0, 12),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return result;
			}
		});
		if(list.size()>0)result = list.get(0);
		return result;
	}
	
	public boolean isExist(String id,int num) {
		boolean result = false;
		String sql = "select count(1) from sectionlittlesummary where teacherid='"+id+"' and num="+num;
		int count = jdbcTemplate.queryForInt(sql);
		if(count>0){
			result = true;
		}
		return result;
	}

}
