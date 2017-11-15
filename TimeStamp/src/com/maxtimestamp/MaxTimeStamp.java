package com.maxtimestamp;

import java.sql.Timestamp;
import java.util.List;

public class MaxTimeStamp 
{

	public static AbstractCargo compareForMaxUID(AbstractCargo tmpcargo1, AbstractCargo tmpcargo2)
	{
		Timestamp currDate = tmpcargo1.getUpdateDt() != null ? tmpcargo1.getUpdateDt(): tmpcargo1.getCreateDt();
		Timestamp latestDate = tmpcargo2.getUpdateDt() != null ? tmpcargo2.getUpdateDt(): tmpcargo2.getCreateDt();
		
		if (currDate != null && latestDate != null && currDate.compareTo(latestDate) > 0) 
			return tmpcargo1;
		else 
			return tmpcargo2;
	}
	
	public static AbstractCargo compareForMaxUID(List <AbstractCargo> tmpcargolist)
	{
		AbstractCargo maxcargo = null;
		if (tmpcargolist != null && tmpcargolist.size() > 0) {
			maxcargo =  tmpcargolist.get(0);
			for (int i = 1; i < tmpcargolist.size(); i++) {
				maxcargo=compareForMaxUID(maxcargo,tmpcargolist.get(i));
			}
		}
		return maxcargo;
	}

	
	
	
}
