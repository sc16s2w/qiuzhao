package com.company.duxiaoman;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int res = calculate(n,a,b);
        System.out.println(res);
    }

    private static int calculate(int n, int a, int b) {
        Queue<Integer> store = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            store.add(i);
        }
        int count = 1;
        while(store.size()!=1){
            if(count%2!=0){
                for(int i = 1;i<a;i++){
                    store.add(store.poll());
                }
                store.poll();
            }
            else{
                for(int i = 1;i<b;i++){
                    store.add(store.poll());
                }
                store.poll();
            }
            count++;
        }
        int res = store.peek();
        return res;
    }

}
