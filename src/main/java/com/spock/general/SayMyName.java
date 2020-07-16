package com.spock.general;

public class SayMyName {

    private Calculate calculate;

    public SayMyName(Calculate calculate){
        this.calculate = calculate;
    }

    public String myNameIs(String name, int age){
        if(name == null || "".equals(name)){
            throw new NullPointerException("Name is null");
        }
        String olderUnder = calculate.isUnderAge(age) ? "underage" : "olderage";
        return String.format("My name is: %s, and you are %s", name, olderUnder);
    }

}
