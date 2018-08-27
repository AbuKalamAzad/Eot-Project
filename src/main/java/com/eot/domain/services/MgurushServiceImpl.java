package com.eot.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eot.domain.dao.MgurushDao;
import com.eot.domain.model.MGurush;
import com.eot.util.EotException;

@Service
@Transactional
public class MgurushServiceImpl  implements MgurushService{

	@Autowired
	 MgurushDao mgurushDao;
	
	@Override
	public void saveOrUpadte(MGurush mgurush) throws EotException {
		
		mgurushDao.saveOrUpdate(mgurush);
	}

	@Override
	public void deleteAdmin(String userId) throws EotException {
		// TODO Auto-generated method stub
		
	}

}
