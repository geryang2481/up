package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.RoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql.RoleSql;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.RoleDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

@Component
public class RoleDaoImpl implements RoleDao {

	private static final Logger log = LogManager.getLogger(RoleDaoImpl.class);
	
	@Autowired
	@Qualifier("devopsJdbcTemplate")
	private JdbcTemplate devopsJdbcTemplate;
	
	@Autowired
	private RoleSql roleSql;
			
	@Override
	public List<Role> findAllRoles() {
		List<Role> roleList = this.devopsJdbcTemplate.query(this.roleSql.findAll(), new RoleDaoRowMapper());  
		
		return roleList;
	}

	@Override
	public Role findRoleByRoleID(long id) {
		Role role = null;
		try{
			role = this.devopsJdbcTemplate.queryForObject(this.roleSql.findByRoleID(String.valueOf(id)), new RoleDaoRowMapper());
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			//log.error(e.getMessage(), e);
			log.info("Unable to find role for roleID: " + id);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return role;
	}
	
	@Override
	public Role findRoleByRoleName(String roleName) {
		Role role = null;
		try{
			role = this.devopsJdbcTemplate.queryForObject(this.roleSql.findByRoleName(roleName), new RoleDaoRowMapper());
			return role;
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			//log.error(e.getMessage(), e);
			log.info("Unable to find role for roleName: " + roleName);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return role;
	}
	
	public Role saveRole(User user, Role role, ServiceAccountDataDO serviceAccountDataDO) {
		return null;
	}

}
