package com.eot.domain.services;

import java.util.Date;
import java.util.List;

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
		mgurush.setCreatedDate(new Date());
		mgurushDao.saveOrUpdate(mgurush);
	}

	@Override
	public void deleteMgurush(String userId) throws EotException {
		
		MGurush gurush = mgurushDao.findMgurushByUserId(userId);
		if(gurush != null) {
		mgurushDao.deleteMgurush(userId);
		}else {
			throw new EotException("Mgurush Does not exits");
		}
	}

	@Override
	public void updateMgurush(String userId,MGurush mgurush) throws EotException {
		
		MGurush gurush = mgurushDao.findMgurushByUserId(userId);
		if(gurush!=null) {
		mgurush.setUpdateDate(new Date());
		mgurushDao.saveOrUpdate(mgurush);
		}else {
			throw new EotException("Mgurush Does not exits");
		}
		
	}

	@Override
	public List<MGurush> findAll() {
		
		return mgurushDao.findAll();
	}

	

}
