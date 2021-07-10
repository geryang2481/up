package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;

public class RevisionDaoRowMapper implements RowMapper<RevisionDO> {
	private static final Logger log = LogManager.getLogger(RevisionDaoRowMapper.class);
	
	@Override
	public RevisionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevisionDO revisionDO = null;
		try {
			revisionDO = new RevisionDO();
			revisionDO.setRevisionID(rs.getBigDecimal("RevisionID"));
			revisionDO.setVersion(rs.getString("Version"));
			revisionDO.setInfo(rs.getString("Info"));
			revisionDO.setComments(rs.getString("Comments"));
			revisionDO.setUuid(rs.getString("UUID"));
			revisionDO.setCreatedBy(rs.getString("CreatedBy"));
			revisionDO.setCreatedDateTime(new Date(rs.getTimestamp("CreatedDateTime").getTime()));
			revisionDO.setUpdatedBy(rs.getString("UpdatedBy"));
			revisionDO.setUpdatedDateTime(new Date(rs.getTimestamp("UpdatedDateTime").getTime()));
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return revisionDO;
	}


}
