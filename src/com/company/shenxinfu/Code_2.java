package com.company.shenxinfu;

public class Code_2 {
    public static void main(String[] args){
        System.out.println(reverseWords("This is sangfor. hjj",2));
    }
    public static String reverseWords (String s, int i) {
        // write code here
        if(i<1||i>s.length()) return s;
        String[] input = s.split(" ");
        String[] store = new String[input.length];
        int t = 0;
        int m = 0;
        for(m =i-1;m>=0;m--){
            store[t] = input[m];
            t++;
        }
        for(int h =input.length-1;h>=i;h--) {
            store[t] = input[h];
            t++;
        }
        String result ="";
        if(store.length<1) return result;
        for(int k=0;k<store.length-1;k++){
            result+=store[k];
            result+=" ";
        }
        result+=store[store.length-1];
        return result;
    }
}
