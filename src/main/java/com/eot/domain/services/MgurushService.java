package com.eot.domain.services;

import com.eot.domain.model.MGurush;
import com.eot.domain.model.SuperAdmin;
import com.eot.util.EotException;

public interface MgurushService {
	
	public void saveOrUpadte(MGurush admin) throws EotException;

	public void deleteAdmin(String userId) throws EotException ;
	

}
