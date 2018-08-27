package com.eot.domain.dao;

import com.eot.domain.model.Commission;

public interface CommissionDao {

	public void saveOrUpadte(Commission commission);

	public void deleteCommission(String id);

	public Commission findCommissionByUserId(String userId);
}
