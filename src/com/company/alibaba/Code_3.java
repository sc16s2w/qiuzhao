package com.company.alibaba;

import java.util.Scanner;

public class Code_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();
        int[] input = new int[num+1];
        for(int i =1;i<=num;i++){
            input[i] = scanner.nextInt();
        }
        int res = calculate(input,k,num);
        System.out.println(res);
}

    private static int calculate(int[] input,int length,int num) {
        double mod = Math.pow(10,9);
        int[][] dp = new int[num+1][num+1];
        boolean[] used = new boolean[input.length];
        for(int i=1;i<=num;i++) dp[i][1] =1;
        for(int i = 2;i<=num;i++){
            for(int j =1;j<=num;j++){
                for(int k = i-1;k>=0;k--){
//                    System.out.println(k+"K");
                    if(input[i]>input[k]&&!used[k]){
                        used[k] = true;
                        dp[i][j] +=dp[k][j-1];
                        dp[i][j]%=mod;
                    }
                }
            }
        }
        int res = 0;
        for(int i =num;i>=1;i--){
            if(used[i]) continue;
            used[i] = true;
            for(int j = length;j>=1;j--){
                res+=dp[i][j];
                res%=mod;
            }

        }
        return res;
        }
    }
