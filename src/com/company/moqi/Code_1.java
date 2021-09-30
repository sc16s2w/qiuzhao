package com.company.moqi;

import java.util.Arrays;
import java.util.Scanner;

//public class Code_1 {
//    public String long_division (String num1, String num2) {
//        // write code here
//        int temp1 = Integer.getInteger(num1);
//        int temp2 = Integer.getInteger(num2);
//        int quotient = temp1/temp2;
//        int remainder = temp1%temp2;
//
//
//    }
//}
public class Code_1 {

    public static void main(String[] args) {
        System.out.println("s=");
    }
    static int digit;
    public static String long_division (String num1, String num2) {
        // write code here
        String[] temp1= num1.split("");
        String[] temp2 = num2.split("");
        int[] input1  = new int[temp1.length];
        int[] input2 = new int[temp2.length];
        int m = 0;
        for(int i=input1.length-1;i>=0;i--){
            input1[i] = Integer.parseInt(temp1[input1.length-i-1]);
            m+=Math.pow(10,input1.length-i-1)*input1[i];
        }
        int n =0;
        for(int i= input2.length-1;i>=0;i--){
            input2[i] = Integer.parseInt(temp2[input2.length-i-1]);
            n+=Math.pow(10,input2.length-i-1)*input2[i];
        }
        if(compare(input1,input2)==0) return 0+","+ Arrays.toString(input1);
        if(compare(input1,input2)==2) return 0+","+0;
        input2 = new int[input1.length];
        for(int i=0;i<temp2.length;i++){
            input2[i] = Integer.parseInt(temp2[i]);
        }
        String str1 = "";
        String str2 = "";
        int flag1 = 0;
        int flag2 = 0;
        for(int i = 0;i < input1.length;i++)
        {
            flag1 = flag1 * 10 + input1[i];
            str1 += flag1 / n;
            flag1 = flag1 % n;
        }
        for(int i = 0;i < str1.length();i++)
        {
            if(str1.charAt(i) != '0')
            {
                flag2 = i;
                break;
            }
        }
        for(int i = flag2;i < str1.length();i++)
        {
            str2 += str1.charAt(i);
        }
        return str2 + "," + flag1;
    }
    public static int compare(int[] input1,int[] input2){
        if(input1.length<input2.length) return 0;
        if(input1.length>input2.length) return 1;
        else{
            for(int i =0;i<input1.length;i++){
                if(input1[i]==input2[i]) continue;
                if(input1[i]>input2[i]) return 1;
                else return 0;
            }
        }
        return 2;
    }

}