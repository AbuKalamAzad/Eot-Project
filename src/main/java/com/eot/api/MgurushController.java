package com.eot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eot.core.EOTConstant;
import com.eot.domain.model.MGurush;
import com.eot.domain.model.SuperAdmin;
import com.eot.domain.services.MgurushService;
import com.eot.domain.services.SuperAdminService;
import com.eot.util.EotException;

@Controller
public class MgurushController {

	@Autowired
	SuperAdminService superAdminService;

	@Autowired
	MgurushService mgurushService;

	@RequestMapping(value = "/api/mgurush/userId", method = RequestMethod.POST)
	public ResponseEntity<Object> gurushCreate(@PathVariable("userId") String userId, @RequestBody MGurush mGurush) {

		try {
			SuperAdmin admin = superAdminService.findAdminByUserId(userId);
			if (admin != null) {
				if (admin.isActive() == true) {
					mgurushService.saveOrUpadte(mGurush);
					return ResponseEntity.status(HttpStatus.OK).body(mGurush);
				} else {
					throw new EotException("super admin not yet login");
				}
			} else {
				throw new EotException(EOTConstant.SUPERADMIN_DOESNOT_EXISTS);
			}
		} catch (EotException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String(e.getMessage()));

		}

	}

}
