package com.company.Duoyi;
import java.util.*;

public class main{
    public static void main(String[] args){
        System.out.println(MLS(new int[]{7,8,2,6,1,1,7,2,4,3,4,7,5,6,8,2}));
        int[] store = new int[]{7,8,2,6,1,1,7,2,4,3,4,7,5,6,8,2};
        quickSort(0,store.length-1,store);
        System.out.println(Arrays.toString(store));
    }
    public static int MLS (int[] arr) {
        // write code here
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        int size = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]==(arr[i-1])){
                continue;
            }
            if(arr[i]==(arr[i-1]+1)){
                result.add(arr[i]);
                size = Math.max(size, result.size());
            }
            else{
                result = new ArrayList<>();
                result.add(arr[i]);
            }
        }
        return size;
    }
    public static void quickSort(int left,int right,int[] input){
        if(left>right) return;
        int pivot = input[left];
        int i = left;
        int j = right;
        while(i!=j){
            while(input[j]>=pivot&&i<j){
                j--;
            }
            while(input[i]<=pivot&&i<j){
                i++;
            }
            if(i<j){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        int temp = input[i];
        input[i] = pivot;
        input[left] = temp;
        quickSort(left,i-1,input);
        quickSort(i+1,right,input);
    }
}
