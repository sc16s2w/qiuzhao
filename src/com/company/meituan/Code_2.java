package com.company.meituan;

import java.util.*;

public class Code_2 {
    static Set<Integer> store = new HashSet<>();
    static Set<Set<Integer>> count = new HashSet<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] input = new int[n][n];
        for(int i = 0;i<m;i++){
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            input[j-1][k-1] = 1;
            input[k-1][j-1] = 1;
        }
        System.out.println(calcultae(input,n));

    }

    private static int calcultae(int[][] input,int n) {
        boolean[] used = new boolean[input.length];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(input[i][j]==1){
                    store = new HashSet<>();
                    used = new boolean[input.length];
                    store.add(i);
                    store.add(j);
                    used[i] = true;
                    dfs(input,n,used,i,j);
                }
            }
        }
        return count.size();
    }
    private static void dfs(int[][] input,int n,boolean[] used,int i,int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) return;
        if (used[j]) return;
        if (input[i][j] != 1) return;
        if (store.size() == 5) {
            count.add(store);
            store = new HashSet<>();
            return;
        }
        used[j] = true;
        store.add(i);
        store.add(j);
        for (int m = 0; m < n; m++) {
            if (input[j][m] == 1 && !used[m]) {
                store.add(j);
                store.add(m);
                dfs(input, n, used, j, m);
            }
        }
    }
}
