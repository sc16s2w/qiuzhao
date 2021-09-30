package com.company.aiqiyi;

import java.util.*;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = calculate(n);
        System.out.println(result);
    }

    public static int calculate(int n){
        HashMap<Integer,Integer> store = new HashMap<>();
        for(int i =1;i<=n;i++){
            int key = sum(i);
            if(store.containsKey(key)) store.put(key,store.get(key)+1);
            else store.put(key,1);
        }
        HashMap<Integer,Integer> transfer = new HashMap<>();
        for(Map.Entry<Integer,Integer> temp:store.entrySet()){
//            System.out.println(temp.getKey()+" "+temp.getValue());
            if(transfer.containsKey(temp.getValue())) transfer.put(temp.getValue(),transfer.get(temp.getValue())+1);
            else transfer.put(temp.getValue(),1);
        }
        List<Map.Entry<Integer,Integer>> iter = new ArrayList<>(transfer.entrySet());
        Collections.sort(iter, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> integerIntegerEntry, Map.Entry<Integer, Integer> t1) {
                return t1.getKey()-integerIntegerEntry.getKey();
            }
        });
//        for(Map.Entry<Integer,Integer> temp:transfer.entrySet()) {
//            System.out.println(temp.getKey() + " " + temp.getValue());
//        }
        return iter.get(0).getValue();
    }
    public static int sum(int n){
        int result = 0;
        while(n!=0){
            result+=n%10;
            n = n/10;
        }
        return result;
    }

}
