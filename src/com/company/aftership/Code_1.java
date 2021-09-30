package com.company.aftership;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = scanner.nextInt();
        }
        int[][] result = singleStack(input);
        for(int i= 0;i<result.length;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }

    private static int[][] singleStack(int[] input) {
        int[][] result = new int[input.length][2];
        for(int i=0;i<input.length;i++){
            result[i][0] = -1;
            result[i][1] = -1;
        }
        Stack<Integer> store = new Stack<>();
        store.add(0);
        for(int i =1;i<input.length;i++){
            if(input[i]>=input[store.peek()]){
                store.add(i);
            }
            else if(input[i]<input[store.peek()]){
                while(!store.isEmpty()&&input[i]<input[store.peek()]){
                    result[store.pop()][1] = i;
                }
                store.add(i);
            }
        }
        store = new Stack<>();
        store.add(input.length-1);
        for(int i =input.length-2;i>=0;i--){
            if(input[i]>=input[store.peek()]){
                store.add(i);
            }
            else if(input[i]<input[store.peek()]){
                while(!store.isEmpty()&&input[i]<input[store.peek()]){
                    result[store.pop()][0] = i;
                }
                store.add(i);
            }
        }
        return result;
    }
}
