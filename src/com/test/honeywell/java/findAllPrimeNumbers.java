package com.test.honeywell.java;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;

public class findAllPrimeNumbers {

    public static void main(String[] args) {
       int number = 2;
       int countX = 1;
       boolean a = false;
        long start = System.currentTimeMillis();
        while (number < 100) {
           //a prime number is a number that is only divisible by itself;
           //prime number are all odd numbers except 2;
           //no number is divisible by more than it's half

           for (int x = 2; x <= number / 2; x++){
               a = false;
               if (number % x == 0 ){
                   a = true;
                   break;
               }
           }
        if ( a == false){
            System.out.println(countX+" "+number);
            countX++;
        }
        number++;
       }
      long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
