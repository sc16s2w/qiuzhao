package com.company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        while(num>0){
            int temp = scanner.nextInt();
            result.add(square(temp));
            num--;
        }
        for(Integer i:result){
            System.out.println(i);
        }
    }
    private static int square(int temp) {
//        int[][] dp = new int[temp+1][3];
//        dp[4][0] = 1;
//        dp[4][1] = 0;
//        dp[4][2] = 0;
//        dp[4][3] = 1;
//        for(int i = 5;i<=temp;i++){
//            dp[i][0] = 1;
//            if((i-dp[i-3][1])>=3) dp[i][1]=dp[i-1][1]+1;
//            if((i-4-3*dp[i][1])>=2) dp[i][2] = dp[i-2][2]+1;
//        }
//        return dp[temp][0]+dp[temp][1]+dp[temp][2];
        if(temp<12) return (temp-4)/3+1;
        int x = (temp-2)/5;
        int y = (temp-2)%5;
        if(y>=3) return 2*x+1;
        return 2*x;
    }

}
