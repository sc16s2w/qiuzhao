package com.company.tplink;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num =scanner.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        int length = scanner.nextInt();
        System.out.println(findMaxProduct(arr,length));
    }
    public static int findMaxProduct(int[] arr,int len){
        int result = arr[0];
        int temp =1;
        for(int i = 0;i<arr.length;i++){
            temp *=arr[i];
            result = Math.max(temp,result);
            if(temp<0) temp = 1;
        }
        return result;
    }
}
