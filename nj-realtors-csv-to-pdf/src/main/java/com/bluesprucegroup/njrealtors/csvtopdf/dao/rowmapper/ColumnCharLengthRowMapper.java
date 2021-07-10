package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.apache.commons.lang3.StringUtils;

public class ColumnCharLengthRowMapper implements RowMapper<String[]> {
	private static final Logger log = LogManager.getLogger(ColumnCharLengthRowMapper.class);
	
	@Override
	public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {
		String[] results = null;
		try {
			results = new String[] {
				StringUtils.isEmpty(rs.getString("COLUMN_NAME")) ? "" : rs.getString("COLUMN_NAME"),
				StringUtils.isEmpty(rs.getString("DATA_TYPE")) ? "" : rs.getString("DATA_TYPE"),
				StringUtils.isEmpty(rs.getString("CHARACTER_MAXIMUM_LENGTH")) ? "0" : rs.getString("CHARACTER_MAXIMUM_LENGTH")
			};
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return results;
	}

}
