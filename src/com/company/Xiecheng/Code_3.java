package com.company.Xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code_3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int ruleLength = scanner.nextInt();
        String input = scanner.next();
        int[][] rule = new int[ruleLength][2];
        for(int i = 0;i<ruleLength;i++){
            rule[i][0] = scanner.nextInt();
            rule[i][1] = scanner.nextInt();
        }
        int result = calculate(input,rule,ruleLength);
        System.out.println(result);
    }

    private static int calculate(String input, int[][] rule, int ruleLength) {
        String[] store = input.split("");
        int count = 0;
        int[] dp = new int[store.length];
        for(int i=0;i<store.length;i++){
            if(store[i].equals("1")){
                count++;
                int result = findMax(rule,count,i,dp);
                if(i>0&&result==0) dp[i] = dp[i-1];
                else dp[i] = result;
            }
            else{
                if(i==0) dp[i] = 0;
                else{
                    dp[i] = dp[i-1];
                    count = 0;
                }
            }
        }
//        for(int i =0;i<dp.length;i++){
//            System.out.println(i+" "+dp[i]);
//        }
        return dp[input.length()-1];
    }

    private static int findMax(int[][] rule, int count,int index,int[] dp) {
        int result = 0;
        List<Integer> store = new ArrayList<>();
        for(int i = 0;i< rule.length;i++){
            if(index==(rule[i][0]-1)&&count==rule[i][0]) store.add(rule[i][1]);
            if(index>=(rule[i][0])&&count>=rule[i][0]) store.add(dp[index-rule[i][0]]+rule[i][1]);
        }
        if(store.isEmpty()) return 0;
        result = Collections.max(store);
        return result;
    }

}
