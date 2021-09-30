package com.company.nanobank;

import java.util.*;

public class Code_1 {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[][] b = {{4, 8}, {10, 15}};
        int[][] res = MergeRange(a,b);
        for(int i = 0;i< res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
    public static int[][] MergeRange (int[][] rangeList1, int[][] rangeList2) {
        // write code here
        List<int[]> store = new ArrayList<>();
        for(int[] t:rangeList1){
            store.add(t);
        }
        for(int[] t:rangeList2){
            store.add(t);
        }
        Collections.sort(store, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]){
                    return ints[1] - t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        int left = store.get(0)[0];
        int right = store.get(0)[1];
        List<int[]> result = new ArrayList<>();
        for(int i =1;i<store.size();i++){
            if(store.get(i)[1]<=right){
                continue;
            }
            else{
                if(store.get(i)[0]<=right){
                    right = store.get(i)[1];
                }
                else{
                    result.add(new int[]{left,right});
                    left = store.get(i)[0];
                    right = store.get(i)[1];
                }
            }
        }
        if(!result.contains(new int[]{left,right})) result.add(new int[]{left,right});
        int[][] finalResult = new int[result.size()][2];
        for(int i = 0;i<result.size();i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}
