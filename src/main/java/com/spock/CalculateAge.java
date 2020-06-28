package com.spock;

public class CalculateAge {

    public boolean isUnderAge(Integer age){
        if(age <= 0 || age == null){
            throw new IllegalArgumentException(String.format("Age cannot be %s", age));
        }
        if(age > 18){
            return false;
        }
        return true;
    }
}
