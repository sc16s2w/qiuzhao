package com.company.shence;

import java.util.Scanner;

public class Code_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                input[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j =n-1;j>=0;j--){
                System.out.println(input[j][i]);
            }
        }
    }
}
