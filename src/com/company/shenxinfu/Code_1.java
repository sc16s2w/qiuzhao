package com.company.shenxinfu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_1 {
    public static void main(String[] args){
        int[] arr = new int[]{9, 3, 4, 3, 5, 6};
        System.out.println(Arrays.toString(shuffle(arr,4)));
    }
    public static int[] shuffle (int[] arr, int i) {
        // write code here
        List<Integer> temp = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        int[] result = new int[arr.length];
        int j= 0;
        for(j=0;j<i;j++){
            temp.add(arr[j]);
        }
        for(;j<arr.length;j++){
            temp1.add(arr[j]);
        }
        int m =0;
        int n = 0;
        int s = 0;
        while(m<temp.size()&&n< temp1.size()){
            if(s%2==0){
                result[s] = temp.get(m);
                m++;
            }
            else{
                result[s] = temp1.get(n);
                n++;
            }
            s++;
        }
        while(m<temp.size()){
            result[s] = temp.get(m);
            m++;
            s++;
        }
        while(n< temp1.size()){
            result[s] = temp1.get(n);
            n++;
            s++;
        }
        return result;
    }
}
