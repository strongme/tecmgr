package org.strongme.tecmgr.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.strongme.tecmgr.bean.Department;

@Service
public class DepartmentService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public List<Department> allDepartment() {
		String sql = "select id,departmentname from department order by id";
		List<Department> result = new ArrayList<Department>();
		result = jdbcTemplate.query(sql, new RowMapper<Department>() {
			public Department mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				Department bean = new Department();
				bean.setId(arg0.getLong(1));
				bean.setDepartmentName(arg0.getString(2));
				return bean;
			}
		});
		return result;
	}
}
