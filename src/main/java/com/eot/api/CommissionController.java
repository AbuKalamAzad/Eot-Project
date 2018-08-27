package com.eot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eot.core.EOTConstant;
import com.eot.domain.model.Commission;
import com.eot.domain.services.CommissionService;
import com.eot.util.EotException;

@Controller
public class CommissionController {

	@Autowired
	CommissionService commissionService;

	/* Api to add commission */
	@RequestMapping(value = "/api/commission", method = RequestMethod.POST)
	public ResponseEntity<Object> addCommission(@RequestBody Commission commission) {
		try {

			commissionService.saveOrUpadte(commission);
			return ResponseEntity.status(HttpStatus.OK).body(commission);

		} catch (EotException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String(e.getMessage()));

		}
	}

	/* Api to update commission */
	@RequestMapping(value = "api/update/{userId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Object> updateCommission(@PathVariable("userId") String userId,
			@RequestBody Commission commission) {

		try {
			Commission comm = commissionService.findCommissionByUserId(userId);
			if (comm != null) {
				commission.setUserId(userId);
				commissionService.saveOrUpadte(commission);
				return ResponseEntity.status(HttpStatus.OK).body(commission);
			} else {
				throw new EotException(EOTConstant.COMMISSION_DOESNT_EXIST);
			}
		} catch (EotException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String(e.getMessage()));
		}

	}
}
