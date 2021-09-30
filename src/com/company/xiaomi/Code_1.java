package com.company.xiaomi;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(calculate(a,b));
    }

    private static int calculate(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 0;i<a.length();i++){
            for(int j =0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
