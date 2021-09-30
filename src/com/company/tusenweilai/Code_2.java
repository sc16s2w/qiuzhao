package com.company.tusenweilai;

import java.util.*;
//5 5
//        a b 1
//        b c 1
//        b d 1
//        d e 1
//        e a 1
//        1
//        e c
public class Code_2 {
    static LinkedList<String> list = new LinkedList<>();
    static List<Integer> re = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<String, List<String>> store = new HashMap<>();
        Map<String,Integer> storeValue = new HashMap<>();
        for(int i = 0;i<m;i++){
            String s = scanner.next();
            String t = scanner.next();
            if(store.containsKey(s)){
                List<String> temp = store.get(s);
                temp.add(t);
                store.put(s,temp);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(t);
                store.put(s,temp);

            }
            String a = s+t;
            storeValue.put(a,scanner.nextInt());
        }
        int group = scanner.nextInt();
        for(int i = 0;i<group;i++){
            list = new LinkedList<>();
            re = new ArrayList<>();
            String s = scanner.next();
            String t = scanner.next();
            list.add(s);
            int res = calculate(s,t,n,store,storeValue);
            if(res == 0) System.out.println("INF");
            else System.out.println(res);
        }
    }

    private static int calculate(String s, String t, int n, Map<String, List<String>> store, Map<String, Integer> storeValue) {
        int res = 0;
        if(!store.containsKey(s)) return 0;
        dfs(t,store,storeValue,s,0,n);
        if(re.isEmpty()) return 0;
        return Collections.min(re);
    }
    private static void dfs(String t, Map<String, List<String>> store, Map<String, Integer> storeValue, String temp,int sum,int n) {
//        System.out.println(list.toString());
        if(list.size()>n) return;
        if(!list.isEmpty()&&list.getLast().equals(t)){
            re.add(sum);
            return;
        }
        if(!store.containsKey(temp)){
            return;
        }
       List<String> li = store.get(temp);
        for(String i:li){
            list.add(i);
            sum+=storeValue.get(temp+i);
            dfs(t,store,storeValue,i,sum,n);
            list.removeLast();
            sum-=storeValue.get(temp+i);
        }
    }

}
