package com.company.tplink;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(reverse(s));

    }
    public static String reverse(String t){
        List<Character> store = new ArrayList<>();
        store.add('a');
        store.add('e');
        store.add('i');
        store.add('o');
        store.add('u');
        char[] ch = t.toCharArray();
        int i = 0;
        int j = ch.length-1;
        while(i<j){
            while(i<j&&store.contains(ch[i])){
                i++;
            }
            while(i<j&&store.contains(ch[j])){
                j--;
            }
//            System.out.println(i+" "+j);
            if(i<j){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        String str="";
        for(int m = 0;m<ch.length;m++){
            str+=ch[m];
        }
        return str;
    }
}
