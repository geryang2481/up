package com.bsg.data.extractor.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bsg.data.extractor.domain.DataInfoDO;

public class DataInfoDORowMapper implements RowMapper<DataInfoDO> {
	private static final Logger log = LogManager.getLogger(DataInfoDORowMapper.class);
	
	@Override
	public DataInfoDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataInfoDO tcustInfoDO = null;
		try {
			tcustInfoDO = new DataInfoDO();
			tcustInfoDO.setCustID(rs.getBigDecimal("CustID") != null ? rs.getBigDecimal("CustID")  : null);
			tcustInfoDO.setCustNo(rs.getString("CustNo") != null ? rs.getString("CustNo") : "");
			tcustInfoDO.setCtID(rs.getInt("CTID") != 0 ? rs.getInt("CTID") : 0);
			tcustInfoDO.setTxtBusAddressee(rs.getString("txtBusAddressee") != null ? rs.getString("txtBusAddressee") : "");
			tcustInfoDO.setnStOfIncorp(rs.getInt("nStOfIncorp") != 0 ? rs.getInt("nStOfIncorp") : 0);
			tcustInfoDO.setBrdMtgDt(rs.getDate("BrdMtgDt") != null ? rs.getDate("BrdMtgDt") : null);
			tcustInfoDO.setnNumSignors(rs.getInt("nNumSignors") != 0 ? rs.getInt("nNumSignors") : 0);
			tcustInfoDO.setLastName(rs.getString("LN") != null ? rs.getString("LN") : "");
			tcustInfoDO.setFirstName(rs.getString("FN") != null ?rs.getString("FN") : "");
			tcustInfoDO.setMiddleName(rs.getString("MN") != null ? rs.getString("MN") : "");
			tcustInfoDO.setDba(rs.getString("DBA") != null ? rs.getString("DBA") : "");
			tcustInfoDO.setTaxID(rs.getString("TaxID") != null ? rs.getString("TaxID") : "");
			tcustInfoDO.setCrID(rs.getInt("CRID") != 0 ? rs.getInt("CRID") : 0);
			tcustInfoDO.setCrdRtDt(rs.getDate("CrdRtDt") != null ? rs.getDate("CrdRtDt") : null);
			tcustInfoDO.setCustSincDt(rs.getDate("CustSincDt") != null ? rs.getDate("CustSincDt") : null);
			tcustInfoDO.setOfficersName(rs.getInt("OfficersName") != 0 ? rs.getInt("OfficersName") : 0);
			tcustInfoDO.setBillAdr1(rs.getString("BillAdr1") != null ? rs.getString("BillAdr1") : "");
			tcustInfoDO.setBillAdr2(rs.getString("BillAdr2") != null ? rs.getString("BillAdr2") : "");
			tcustInfoDO.setBillCity(rs.getString("BillCity") != null ? rs.getString("BillCity") : "");
			tcustInfoDO.setStateID(rs.getInt("StateID") != 0 ? rs.getInt("StateID") : 0);
			tcustInfoDO.setBillZip(rs.getString("BillZip") != null ? rs.getString("BillZip") : "");
			tcustInfoDO.setOthAdd(rs.getString("OthAdd") != null ? rs.getString("OthAdd") : "");
			tcustInfoDO.setOthAdd2(rs.getString("OthAdd2") != null ? rs.getString("OthAdd2") : "");
			tcustInfoDO.setOthCity(rs.getString("OthCity") != null ? rs.getString("OthCity") : "");
			tcustInfoDO.setOthSt(rs.getInt("OthSt") != 0 ? rs.getInt("OthSt") : 0);
			tcustInfoDO.setOthZip(rs.getString("OthZip") != null ? rs.getString("OthZip") : "");
			tcustInfoDO.setFrmDt(rs.getDate("FrmDt") != null ? rs.getDate("FrmDt") : null);
			tcustInfoDO.setBckgrd(rs.getString("Bckgrd") != null ? rs.getString("Bckgrd") : "");
			tcustInfoDO.setFincAnal(rs.getString("FincAnal") != null ? rs.getString("FincAnal") : "");
			tcustInfoDO.setLiq(rs.getString("Liq") != null ? rs.getString("Liq") : "");
			tcustInfoDO.setInc(rs.getString("Inc") != null ? rs.getString("Inc") : "");
			tcustInfoDO.setCshFl(rs.getString("CshFl") != null ? rs.getString("CshFl") : "");
			tcustInfoDO.setCharacter(rs.getString("Character") != null ? rs.getString("Character") : "");
			tcustInfoDO.setMgmt(rs.getString("Mgmt") != null ? rs.getString("Mgmt") : "");
			tcustInfoDO.setDtMgmt(rs.getDate("DtMgmt") != null ? rs.getDate("DtMgmt") : null);
			tcustInfoDO.setDtCafl(rs.getDate("DtCafl") != null ? rs.getDate("DtCafl") : null);
			tcustInfoDO.setDtCap(rs.getDate("DtCap") != null ? rs.getDate("DtCap") : null);
			tcustInfoDO.setDtBck(rs.getDate("DtBck") != null ? rs.getDate("DtBck") : null);
			tcustInfoDO.setDtColl(rs.getDate("DtColl") != null ? rs.getDate("DtColl") : null);
			tcustInfoDO.setDtFinPrep(rs.getDate("DtFinPrep") != null ? rs.getDate("DtFinPrep") : null);
			tcustInfoDO.setDtInc(rs.getDate("DtInc") != null ? rs.getDate("DtInc") : null);
			tcustInfoDO.setOthCom(rs.getString("OthCom") != null ? rs.getString("OthCom") : "");
			tcustInfoDO.setDtOthCom(rs.getDate("DtOthCom") != null ? rs.getDate("DtOthCom") : null);
			tcustInfoDO.setDtItemAnl(rs.getDate("DtItemAnl") != null ? rs.getDate("DtItemAnl") : null);
			tcustInfoDO.setLev(rs.getString("Lev") != null ? rs.getString("Lev") : "");
			tcustInfoDO.setCap(rs.getString("Cap") != null ? rs.getString("Cap") : "");
			tcustInfoDO.setExpo(rs.getBigDecimal("Expo") != null ? rs.getBigDecimal("Expo") : null);
			tcustInfoDO.setCeID(rs.getInt("CEID") != 0 ? rs.getInt("CEID") : 0);
			tcustInfoDO.setBirDt(rs.getDate("BirDt") != null ? rs.getDate("BirDt") : null);
			tcustInfoDO.setBankID(rs.getInt("BankID") != 0 ? rs.getInt("BankID") : 0);
			tcustInfoDO.setSalut(rs.getString("Salut") != null ? rs.getString("Salut") : "");
			tcustInfoDO.setStrWkDt(rs.getDate("StrWkDt") != null ? rs.getDate("StrWkDt") : null);
			tcustInfoDO.setStrengths(rs.getString("Strengths") != null ? rs.getString("Strengths") : "");
			tcustInfoDO.setWeak(rs.getString("Weak") != null ? rs.getString("Weak")  : "");
			tcustInfoDO.setLntID(rs.getInt("LNTID") != 0 ? rs.getInt("LNTID") : 0);
			tcustInfoDO.setMstID(rs.getInt("MSTID") != 0 ? rs.getInt("MSTID") : 0);
			tcustInfoDO.setOrID(rs.getInt("ORID") != 0 ? rs.getInt("ORID") : 0);
			tcustInfoDO.setNumYears(rs.getFloat("NumYears") != 0 ? rs.getFloat("NumYears") : 0);
			tcustInfoDO.setClsID(rs.getInt("CLSID") != 0 ? rs.getInt("CLSID") : 0);
			tcustInfoDO.setCcID(rs.getInt("CCID") != 0 ? rs.getInt("CCID") : 0);
			tcustInfoDO.setOcID(rs.getInt("OCID") != 0 ? rs.getInt("OCID") : 0);
			tcustInfoDO.setRepID(rs.getInt("RepID") != 0 ? rs.getInt("RepID")  : 0);
			tcustInfoDO.setLink(rs.getString("Link") != null ? rs.getString("Link") : "");
			tcustInfoDO.setTransUtil(rs.getBoolean("bTransUtil") != false ? rs.getBoolean("bTransUtil") : false);
			tcustInfoDO.setDtAnniv(rs.getDate("dtAnniv") != null ? rs.getDate("dtAnniv") : null);
			tcustInfoDO.setdCredLim(rs.getFloat("dCredLim") != 0 ? rs.getFloat("dCredLim") : 0);
			tcustInfoDO.setDtDeath(rs.getDate("dtDeath") != null ? rs.getDate("dtDeath") : null);
			tcustInfoDO.setDtDLExp(rs.getDate("dtDLExp") != null ? rs.getDate("dtDLExp") : null);
			tcustInfoDO.setTxtDLNum(rs.getString("txtDLNum") != null ? rs.getString("txtDLNum") : "");
			tcustInfoDO.setnDLState(rs.getInt("nDLState") != 0 ? rs.getInt("nDLState") : 0);
			tcustInfoDO.setTxtIPAddr(rs.getString("txtIPAddr") != null ? rs.getString("txtIPAddr") : "");
			tcustInfoDO.setnLocCode(rs.getInt("nLocCode") != 0 ? rs.getInt("nLocCode") : 0);
			tcustInfoDO.setTxtMaiden(rs.getString("txtMaiden") != null ? rs.getString("txtMaiden") : "");
			tcustInfoDO.setnCountry(rs.getInt("nCountry") != 0 ? rs.getInt("nCountry") : 0);
			tcustInfoDO.setLngCounty(rs.getInt("lngCounty") != 0 ? rs.getInt("lngCounty") : 0);
			tcustInfoDO.setLngOthCounty(rs.getInt("lngOthCounty") != 0 ? rs.getInt("lngOthCounty") : 0);
			tcustInfoDO.setLngOthCountry(rs.getInt("lngOthCountry") != 0 ? rs.getInt("lngOthCountry") : 0);
			tcustInfoDO.setLngSuffix(rs.getInt("lngSuffix") != 0 ? rs.getInt("lngSuffix") : 0);
			tcustInfoDO.setTxtEntOrgID(rs.getString("txtEntOrgID") != null ? rs.getString("txtEntOrgID") : "");
			tcustInfoDO.setChkEntOrg(rs.getBoolean("chkEntOrg") != false ? rs.getBoolean("chkEntOrg") : false);
			tcustInfoDO.setChkDBASecState(rs.getBoolean("chkDBASecState") != false ? rs.getBoolean("chkDBASecState") : false);
			tcustInfoDO.setnGov(rs.getInt("nGov") != 0 ? rs.getInt("nGov") : 0);
			tcustInfoDO.setEmployee(rs.getBoolean("bEmployee") != false ? rs.getBoolean("bEmployee") : false);
			tcustInfoDO.setCreditScore(rs.getString("CreditScore") != null ? rs.getString("CreditScore") : "");
			tcustInfoDO.setCsDate(rs.getDate("CSDate") != null ? rs.getDate("CSDate") : null);
			tcustInfoDO.setTxtSpouse(rs.getString("txtSpouse") != null ? rs.getString("txtSpouse") : "");
			tcustInfoDO.setDtLev(rs.getDate("DtLev") != null ? rs.getDate("DtLev") : null);
			tcustInfoDO.setDtLiq(rs.getDate("DtLiq") != null ? rs.getDate("DtLiq") : null);
			tcustInfoDO.setDtWeak(rs.getDate("DtWeak") != null ? rs.getDate("DtWeak") : null);
			tcustInfoDO.setDtActivated(rs.getBoolean("bDTActivated") != false ? rs.getBoolean("bDTActivated") : false);
			tcustInfoDO.setForProfit(rs.getInt("ForProfit") != 0 ?rs.getInt("ForProfit") : 0);
			tcustInfoDO.setEthnicity(rs.getInt("Ethnicity") != 0 ? rs.getInt("Ethnicity") : 0);
			tcustInfoDO.setGender(rs.getInt("Gender") != 0 ? rs.getInt("Gender") : 0);
			tcustInfoDO.setIncInLastImport(rs.getBoolean("bIncInLastImport") != false ? rs.getBoolean("bIncInLastImport") : false);
			tcustInfoDO.setTxtSuffix(rs.getString("txtSuffix") != null ? rs.getString("txtSuffix").replace("null", "") : "");
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return tcustInfoDO;
	}

}
