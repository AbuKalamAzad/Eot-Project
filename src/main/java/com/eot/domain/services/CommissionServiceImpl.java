package com.eot.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eot.domain.dao.CommissionDao;
import com.eot.domain.model.Commission;
import com.eot.util.EotException;

@Service
@Transactional
public class CommissionServiceImpl implements CommissionService {
	
	@Autowired
	CommissionDao commissionDao;

	@Override
	public void saveOrUpadte(Commission commission) throws EotException {

		commissionDao.saveOrUpadte(commission);
	}

	@Override
	public void deleteCommission(String id) throws EotException {
		// TODO Auto-generated method stub

	}

	@Override
	public Commission findCommissionByUserId(String userId) {
		Commission commission = commissionDao.findCommissionByUserId(userId);
		return commission;
	}

}
