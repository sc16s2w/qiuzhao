package com.company.moqi;

import java.util.Scanner;

public class Code_5{
    public static void main(String[] args){
      System.out.println(reverse_reasoning(10.00f, 6.00F));
    }
    public static String reverse_reasoning (float sum, float sub) {

//        System.out.println(Float.valueOf(sum).doubleValue());
        double a =(sum+sub)/2;
        double b =sum-a;
        String result = a+"0"+","+b+"0";
        return result;
        // write code here
    }
}
