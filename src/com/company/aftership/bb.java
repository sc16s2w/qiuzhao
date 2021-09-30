package com.company.aftership;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class bb {
    // public static int counter = 0;

    public static int bbb(int n, int k, String s){
        if(s.length() < k){
            return 0;
        }
        int res = aaa(n, k, s);
        int a = bbb(n-1, k, s.substring(1, n));
        int b = bbb(n-1, k, s.substring(0, n-1));
        return res+a+b;
    }

    public static int aaa(int n, int k, String s){
        int counter = 0;

        Set<Character> st = new HashSet<>();

        for(int i = 0; i < n-k+1; i++){
            for(int j = 0; j < k; j++){
                st.add(s.charAt(i+j));
            }

            if(st.size() == k){
                counter++;
            }
            st.clear();
        }

        return counter;
    }
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void retrace(int index,String s,int k){

        if(index == s.length()){
            return;
        }
        if(sb.length()>=k){
            if(judge(sb.toString(),k)){
                System.out.println(sb.toString());
                count++;
            }
        }
        for(int i = index;i<s.length();i++){
            sb.append(s.charAt(i));
            retrace(index+1,s,k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static boolean judge(String s, int k){
        HashSet<Character> store = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            store.add(s.charAt(i));
        }
        if(store.size()==k) return true;
        return false;
    }
    public static void main(String[] args) {
         retrace(0, "eecbad",5);
        // System.out.println(counter);
        System.out.println(count);
    }
}