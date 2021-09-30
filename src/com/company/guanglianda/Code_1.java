package com.company.guanglianda;

import java.util.*;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int type = scanner.nextInt();
        int[] biscuit = new int[num];
        for(int i =0;i<num;i++){
            biscuit[i] = scanner.nextInt();
        }
        int[] categoryInput = new int[type];
        for(int i =0;i<type;i++){
            categoryInput[i] = scanner.nextInt();
        }
        Map<Integer,Integer> store = count(biscuit);
        for(int i = 0;i<type;i++){
            System.out.println(store.get(categoryInput[i]-1));
        }
    }

    private static Map<Integer, Integer> count(int[] biscuit) {
        Map<Integer,Integer> store = new HashMap<>();
        Set<Integer> judge = new HashSet<>();
        for(int i = biscuit.length-1;i>=0;i--){
            judge.add(biscuit[i]);
            store.put(i,judge.size());
        }
        return store;
    }
}
