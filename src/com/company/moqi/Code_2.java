package com.company.moqi;

import java.util.*;

public class Code_2 {
    public static String run_length_encoding (String s) {
        // write code here
        s= s.toUpperCase();
        String result = "";
        List<Character> store = new ArrayList<>();
        store.add(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                store.add(s.charAt(i));
            }
            else{
                result+="("+store.get(0)+","+store.size()+")";
                store = new ArrayList<>();
                store.add(s.charAt(i));
            }
        }
        result+="("+store.get(0)+","+store.size()+")";
        return result;
    }
    public static void main(String[] args){
        System.out.println(run_length_encoding("aAABBbBCCCaaaaa"));
    }

}
