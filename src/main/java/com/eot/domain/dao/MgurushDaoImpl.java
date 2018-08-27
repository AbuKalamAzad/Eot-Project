package com.eot.domain.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eot.domain.model.MGurush;

@Repository
public class MgurushDaoImpl implements MgurushDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void saveOrUpdate(MGurush mGurush) {
		sessionFactory.getCurrentSession().saveOrUpdate(mGurush);
		
	}

	@Override
	public void deleteMgurush(String userId) {
		
		
	}

}
