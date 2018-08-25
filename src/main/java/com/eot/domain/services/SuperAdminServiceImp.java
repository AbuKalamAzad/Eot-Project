package com.eot.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eot.domain.dao.SuperAdminDao;
import com.eot.domain.model.SuperAdmin;
import com.eot.util.EotException;

@Service
@Transactional
public class SuperAdminServiceImp implements SuperAdminService {

	@Autowired
	SuperAdminDao adminDao;

	public void setAdminDao(SuperAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void saveOrUpadte(SuperAdmin admin) throws EotException {

		SuperAdmin superAdmin = adminDao.getAdmin();

		if (superAdmin == null) {
			adminDao.saveOrUpadte(admin);
		} else {
			throw new EotException("already exists delete older and try");
		}

	}

	@Override
	public void deleteAdmin(Long userId) throws EotException {
		SuperAdmin superAdmin = adminDao.findAdminByUserId(userId);
		if (superAdmin != null) {
			adminDao.deleteAdmin(userId);
		} else {
			throw new EotException("admin  does not exists");
		}

	}

	@Override
	public SuperAdmin findAdminByName(Long userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adminLogin(SuperAdmin admin) throws EotException {

		SuperAdmin superAdmin = adminDao.findAdminByUserId(admin.getUserId());

		if (superAdmin != null) {
			if ((superAdmin.getPassword().equals(admin.getPassword()))
					&& (superAdmin.getUserId().equals(admin.getUserId()))) {
				superAdmin.setActive(true);
				adminDao.saveOrUpadte(superAdmin);
			} else {
				throw new EotException("Invalid login");
			}
		} else {
			throw new EotException("admin does not exists");
		}

	}

}
