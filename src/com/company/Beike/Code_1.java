package com.company.Beike;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        int[] result = new int[groupNum];
        for(int i =0;i<groupNum;i++){
            result[i] = numWood(scanner.nextInt());
        }
        for(int i =0;i<groupNum;i++){
            System.out.println(result[i]);
        }
    }

    private static int numWood(int nextInt) {
        if(nextInt<3) return 1;
        if(nextInt==3) return 2;
        return nextInt/2;
    }
}
