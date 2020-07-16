package com.spock.general;

public class Calculate {

    public static boolean isUnderAge(Integer age){
        if(age <= 0 || age == null){
            throw new IllegalArgumentException(String.format("Age cannot be %s", age));
        }
        if(age > 18){
            return false;
        }
        return true;
    }

    public static Integer calculateMean(Integer a, Integer b){
        try{
        Thread.sleep(1000);
            return (a+b)/2;
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
