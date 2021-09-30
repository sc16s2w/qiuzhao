package com.company.Beike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Code_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int abandon = scanner.nextInt();
        int value = scanner.nextInt();
        int[] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = scanner.nextInt();
        }
        System.out.println(maxValue(input,abandon,value));

    }

    private static int maxValue(int[] input, int abandon, int value) {
        Arrays.sort(input);
        int result = 0;
        int[][] dp = new int[input.length][input.length+1];
        for(int j = 0;j<input.length;j++){
            dp[0][j] = input[0];
        }
        for(int i =1;i<input.length;i++){
            for(int j=1;j<=input.length;j++){
                if(j>abandon&&input[j-abandon]>value){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+input[i]);
                }
            }
        }
        return dp[input.length][input.length];
    }
}
