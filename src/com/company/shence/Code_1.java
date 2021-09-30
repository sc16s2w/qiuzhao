package com.company.shence;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[2];
        input[0] = scanner.nextInt();
        input[1] = scanner.nextInt();
        int m = scanner.nextInt();
        int result = calculate(input,m);
        System.out.println(result);
    }

    private static int calculate(int[] input, int m) {
        if((input[0]<0&&input[1]==0)||(input[0]==0&&input[1]<0)){
            return -1;
        }
        int result = 0;
        int temp = 0;
        temp = input[0]+input[1];
        while(temp<m){
            temp = input[0]+input[1];
            if(input[0]>input[1]) input[1] = temp;
            else input[0] = temp;
            result++;
        }
        return result;
    }
}
