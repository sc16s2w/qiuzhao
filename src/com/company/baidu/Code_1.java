package com.company.baidu;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int size = scanner.nextInt();
        int[][] origin = new int[num][num];
        for(int i =0;i<num;i++){
            for(int j =0;j<num;j++){
                origin[i][j] = scanner.nextInt();
            }
        }
        int[][] result = change(origin,size);
        for(int i =0;i< result.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<result.length-1;j++){
                sb.append(result[i][j]);
                sb.append(" ");
            }
            sb.append(result[i][result.length-1]);
            System.out.println(sb.toString());
        }
    }

    private static int[][] change(int[][] origin, int size) {
        int[][] result = new int[origin.length*size][origin.length*size];
        for(int i = 0;i<origin.length;i++){
            for(int j = 0;j<origin[0].length;j++){
                for(int m = size*i;m<size*i+size;m++){
                    for (int n = j*size; n < size*j+size; n++) {
                        result[m][n] = origin[i][j];
                    }
                }
            }
        }
        return result;
    }
}
