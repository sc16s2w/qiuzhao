package com.company.huaqi;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(compareST(s,t));
    }
    public static boolean compareST(String s, String t){
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for(int i=0;i<length;i++){
//            System.out.println(s);
            s=s.substring(1,length)+s.charAt(0);
            if(s.equals(t)) return true;
        }
        return false;

    }
}
