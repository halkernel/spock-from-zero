package com.spock.enums;

public enum ControllerConstants {

    BASE("/api"),
    PERSONS("/persons");

    private String resource;

    ControllerConstants(String resource){
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
