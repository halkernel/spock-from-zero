package com.spock.general;

public class SayMyName {

    private CalculateAge calculateAge;

    public SayMyName(CalculateAge calculateAge){
        this.calculateAge = calculateAge;
    }

    public String myNameIs(String name, int age){
        if(name == null || "".equals(name)){
            throw new NullPointerException("Name is null");
        }
        String olderUnder = calculateAge.isUnderAge(age) ? "underage" : "olderage";
        return String.format("My name is: %s, and you are %s", name, olderUnder);
    }

}
