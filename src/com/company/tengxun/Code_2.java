package com.company.tengxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num>0){
            int group = scanner.nextInt();
            int[] input = new int[group];
            for(int i =0;i<group;i++){
                input[i]=scanner.nextInt();
            }
            int res = calculate(input);
            num--;
            System.out.println(res);
        }
    }

    private static int calculate(int[] input) {
        List<Integer> result = new ArrayList<>();
        for(int i =0;i<input.length;i++){
            int sum = input[i];
            int res = i+input[i];
            while(res<input.length){
                sum+=input[res];
                res = res+input[res];
//                System.out.println(res+" "+" "+i+" "+sum);
            }
//            System.out.println(sum);
            result.add(sum);
        }
        return Collections.max(result);
    }
}
