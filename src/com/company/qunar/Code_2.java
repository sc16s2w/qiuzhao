package com.company.qunar;

import java.util.*;

public class Code_2 {
    public static void main(String[] args){
        int[] arr = new int[]{-1,1,4,-9,-8};
        System.out.println(solution(arr));
    }
    static LinkedList<Integer> store = new LinkedList<>();
    static int result = Integer.MIN_VALUE;
    public static int solution(int[] arr) {
        boolean[] used = new boolean[arr.length];
        retrace(0,arr,used);
        return result;

    }
    public static void retrace(int sum,int[] arr,boolean[] used){
        if(store.size() == arr.length){
            return;
        }
        for(int i = 0;i<arr.length;i++){
            if(used[i]) continue;
            used[i] = true;
            store.add(arr[i]);
            sum+=store.size()*arr[i];
            result = Math.max(result,sum);
            retrace(sum,arr,used);
            store.removeLast();
            used[i] = false;
            sum-=store.size()*arr[i];
        }

    }
}
