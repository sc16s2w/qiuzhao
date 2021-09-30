package com.company.xinyeshujing;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String result = calculate(num);
        System.out.println(result);
    }

    private static String calculate(int num) {
        StringBuilder sb = new StringBuilder();
        int n = num;
        sb.append(num);
        sb.append("=");
        for(int i =2;i<num;i++){
            while(n!=1&&n%i==0){
                n=n/i;
                sb.append(i);
                sb.append("*");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
