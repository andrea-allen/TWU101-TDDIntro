package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException{

        if(i==0){
            return 1;
        }

        if(i>0){
            return i*compute(i-1);
        }

        if(i<0){
            throw new IllegalArgumentException();
        }

        return null;
    }


}
