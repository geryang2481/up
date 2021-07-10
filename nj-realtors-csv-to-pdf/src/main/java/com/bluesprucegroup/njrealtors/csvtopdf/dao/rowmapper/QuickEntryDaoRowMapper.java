package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;

public class QuickEntryDaoRowMapper  implements RowMapper< QuickEntryDO>{
	private static final Logger log = LogManager.getLogger(QuickEntryDaoRowMapper.class);

	@Override
	public QuickEntryDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuickEntryDO quickEntryDO = null;
		try {
			quickEntryDO = new QuickEntryDO();
			quickEntryDO.setQuickEntryID(rs.getBigDecimal("QuickEntryID"));
			quickEntryDO.setFileTypeID((String)rs.getString("FileTypeID"));
			quickEntryDO.setName((String)rs.getString("Name"));
			quickEntryDO.setDescription((String)rs.getString("Description"));
			quickEntryDO.setElements(rs.getBytes("Elements"));
			quickEntryDO.setUuid((String)rs.getString("UUID"));
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
        
		return quickEntryDO;
	}
}
