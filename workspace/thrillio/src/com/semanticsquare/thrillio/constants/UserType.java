package com.semanticsquare.thrillio.constants;

public enum UserType {
    USER("user"),
    EDITOR("editor"),
    CHIEF_EDITOR("chiefeditor");
    private String name;
    public String getName() {
    	return name;
    }
    private UserType(String name) {
    	this.name = name;
    }
    
}
