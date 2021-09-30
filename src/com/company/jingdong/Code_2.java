package com.company.jingdong;

import java.util.*;

public class Code_2 {
    static Set<Integer> start = new HashSet<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int k = scanner.nextInt();
        int[][] store = new int[n+1][n+1];
        int[][] storeMin = new int[n+1][n+1];
        for(int i = 1;i<n+1;i++){
            int num = scanner.nextInt();
            for(int j = 1;j<=num;j++){
                int temp =scanner.nextInt();
                store[i][temp] = 1;
                storeMin[temp][i] = -1;
            }
        }
        for(int i = 0;i<k;i++){
            int operation = scanner.nextInt();
            int number = scanner.nextInt();
            int output = 0;
            if(operation == 1) output = operate(operation,number,store,n);
            else output = operateMin(operation,number,storeMin,n);
            System.out.println(output);
        }
    }

    public static int operate(int operation, int number, int[][] store,int n) {
        boolean[][] used = new boolean[n+1][n+1];
        for(int j = 1;j<=n;j++){
            start.add(number);
            if(store[number][j]==1){
                dfs(number,j,store,n,used);
            }
        }

        return start.size();

    }
    public static void dfs(int i, int j,int[][] store,int n,boolean[][] used){
        if(i<0||i>n||j<0||j>n) return;
        if(store[i][j]==0) return;
        if(store[i][j]==-1) return;
        if(used[i][j]) return;
//        System.out.println(i+" "+j);
        start.add(j);
        used[i][j] =true;
        for(int m =1;m<=n;m++){
            if(store[j][m]==1){
                dfs(j,m,store,n,used);
            }
        }
    }
    public static int operateMin(int operation, int number, int[][] store,int n) {
        boolean[][] used = new boolean[n+1][n+1];
        for(int j = 1;j<=n;j++){
//            System.out.println(number);
            start.remove(Integer.valueOf(number));
            if(store[number][j]==-1){
                dfsMin(number,j,store,n,used);
            }
        }
        return start.size();
    }
    public static void dfsMin(int i, int j,int[][] store,int n,boolean[][] used){
        if(i<0||i>n||j<0||j>n) return;
        if(store[i][j]==0) return;
        if(store[i][j]==1) return;
        if(used[i][j]) return;
//        System.out.println(i+" "+j);
//        System.out.println(j)
        start.remove(Integer.valueOf(j));
        used[i][j] =true;
        for(int m =1;m<=n;m++){
            if(store[j][m]==-1){
                dfsMin(j,m,store,n,used);
            }
        }
    }
}
