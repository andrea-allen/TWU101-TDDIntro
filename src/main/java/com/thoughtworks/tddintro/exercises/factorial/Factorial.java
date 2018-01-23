package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {
    public Integer compute(int i) {

        if(i==0){
            return 1;
        }

        if(i>0){
            return i;
        }

        return -1;
    }


}
