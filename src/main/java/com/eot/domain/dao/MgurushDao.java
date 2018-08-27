package com.eot.domain.dao;

import com.eot.domain.model.MGurush;

public interface MgurushDao {
	
	
	public void saveOrUpdate(MGurush mGurush);
	
	public void deleteMgurush(String userId);
		
	

}
