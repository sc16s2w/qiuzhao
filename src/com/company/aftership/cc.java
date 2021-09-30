package com.company.aftership;

import java.util.Arrays;
import java.util.Scanner;

public class cc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int times = scanner.nextInt();
        int[][] input = new int[row][row];
        for(int i =0;i<row;i++){
            for(int j =0;j<row;j++){
                input[i][j] = scanner.nextInt();
            }
        }
        int[][] enrich = enlarge(input,times);
        for(int i =0;i< enrich.length;i++){
            String str = "";
            for(int j = 0;j<enrich[i].length-1;j++){
                str+=enrich[i][j]+" ";
            }
            str+=enrich[i][enrich[i].length-1];
            System.out.println(str);
        }
    }

    private static int[][] enlarge(int[][] input,int times) {
        int[][] result = new int[input.length*times][input.length*times];
        for(int i = 0;i<input.length;i++){
            for(int j =0;j<input.length;j++){
                for(int m = times*i;m<times*(i+1);m++){
                   for(int n=times*j;n<times*(j+1);n++){
                       result[m][n] = input[i][j];
                   }
                }
            }
        }
        return result;
    }

}
