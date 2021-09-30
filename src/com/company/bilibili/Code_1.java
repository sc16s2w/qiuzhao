package com.company.bilibili;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> store = new ArrayList<>();
        boolean flag;
        int times = 0;
        int ensure = 0;
        while(scanner.hasNext()){
            List<Integer> input = new ArrayList<>();
            String s = scanner.next();
            String[] temp = s.split("");
            for(int i = 0;i< temp.length;i++){
                if(temp[i].equals("[")||temp[i].equals("]")||temp[i].equals(",")){
                    continue;
                }
                input.add(Integer.valueOf(temp[i]));
            }
            store.add(input);
            if(temp[temp.length-1].equals("]")) break;
        }
        scanner.close();
//        for(List<Integer> t:store){
//            for(Integer h:t){
//                System.out.println(h);
//            }
//        }

        int res =calculate(store);
        System.out.println(res);
    }

    private static int calculate(List<List<Integer>> store) {
        boolean[][] used = new boolean[store.size()][store.get(0).size()];
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<store.size();i++){
            for(int j = 0;j<store.get(i).size();j++){
                if(store.get(i).get(j)==1&&!used[i][j]){
                    result.add(dfs(i,j,used,store));
                }
            }
        }
        if(result.isEmpty()) return 0;
        return Collections.max(result);
    }

    private static int dfs(int i, int j, boolean[][] used, List<List<Integer>> store) {
        if(i<0||j<0||i>=store.size()||j>=store.get(0).size()){
            return 0;
        }
        if(store.get(i).get(j)==0) return 0;
        if(used[i][j]) return 0;
        used[i][j] =true;
        int a = dfs(i-1,j,used,store);
        int b = dfs(i+1,j,used,store);
        int c = dfs(i,j-1,used,store);
        int d = dfs(i,j+1,used,store);
//        System.out.println(a+" "+b+" r"+c+" "+d+" "+res);
        return a+b+c+d+1;
    }
}

//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,1,1,1,1,0,0,0,0,0,0,0,0],
//        [0,1,0,0,1,1,0,0,1,0,1,0,0],
//        [0,1,0,0,1,1,0,0,1,1,1,0,0],
//        [0,0,0,0,0,0,0,0,0,0,1,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
