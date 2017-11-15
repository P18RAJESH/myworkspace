package com.maxtimestamp;

import java.sql.Timestamp;

public class AbstractCargo 
{
	public String UpdateUserId;
	public Timestamp UpdateDt;
	public String CreateUserId;
	public Timestamp CreateDt;
	
	
	public AbstractCargo( String createUserId, Timestamp createDt,String updateUserId, Timestamp updateDt)
	{
		UpdateUserId = updateUserId;
		UpdateDt = updateDt;
		CreateUserId = createUserId;
		CreateDt = createDt;
	}

	public AbstractCargo() {
		// TODO Auto-generated constructor stub
	}

	public String getUpdateUserId() {
		return UpdateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		UpdateUserId = updateUserId;
	}

	public Timestamp getUpdateDt() {
		return UpdateDt;
	}

	public void setUpdateDt(Timestamp updateDt) {
		UpdateDt = updateDt;
	}

	public String getCreateUserId() {
		return CreateUserId;
	}

	public void setCreateUserId(String createUserId) {
		CreateUserId = createUserId;
	}

	public Timestamp getCreateDt() {
		return CreateDt;
	}

	public void setCreateDt(Timestamp createDt) {
		CreateDt = createDt;
	}
	
	public int size() {
		return 0;
	}
}
