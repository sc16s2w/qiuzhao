package com.company.alibaba;

import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num>0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int res = calculate(n,k);
            System.out.println(res);
            num--;
        }
    }

    private static int calculate(int n, int k) {
        int count = 0;
        for(int  i =1;i<n;i++){
            for(int j = i+1;j<=n;j++){
                if(i%j==k||j%i==k)  count++;
            }
        }
        return count;
    }
}
