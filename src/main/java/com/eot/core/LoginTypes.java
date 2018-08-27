package com.eot.core;

public enum LoginTypes {

	SUPERADMIN("SUPERADMIN", 10), MGURUSH("MGURUSH", 20);

	private final String key;
	private final Integer value;

	LoginTypes(String key, int value) {
		this.key = key;
		this.value = value;

	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}

}
