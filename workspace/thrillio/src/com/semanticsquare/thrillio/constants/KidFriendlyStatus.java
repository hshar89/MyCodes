package com.semanticsquare.thrillio.constants;

public enum KidFriendlyStatus {
	APPROVED("approved"),
	REJECTED("rejected"),
	UNKNOWN("unknown");
	String name;	
	private KidFriendlyStatus(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
