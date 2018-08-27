package com.eot.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mgurush")
public class MGurush {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String userName;
	

	@Column(unique = true)
	private String userId;
	
	private String password;
	
	private boolean isActive;
	
	private Long userType;
	
	private Long transactionLimit;
	
	

	public Long getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(Long transactionLimit) {
		transactionLimit = transactionLimit;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	
}
