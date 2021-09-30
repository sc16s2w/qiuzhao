package com.company.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1 {
    static boolean result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        while(num>0){
            result = false;
            sb = new StringBuilder();
            String input = s.next();
            boolean[] used = new boolean[input.length()];
            char[] ch = input.toCharArray();
            Arrays.sort(ch);
            calculate(ch,0,used);
            if(result) System.out.println("YES");
            else System.out.println("NO");
            num--;
        }
    }
    private static void calculate(char[] next, int index, boolean[] used){
        if(isNotHuiwen(sb.toString())) result = true;
        if(index==next.length) return;
        for(int i =0;i<next.length;i++){
            if(used[i]) continue;
            if(i>0&&next[i]==next[i-1]&&used[i-1]){
                continue;
            }
            sb.append(next[i]);
            used[i] =true;
            calculate(next,i+1,used);
            used[i] =false;
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private static boolean isNotHuiwen(String toString) {
        if(toString.length()==1) return false;
        int i = 0;
        int j = toString.length()-1;
        char[] ch = toString.toCharArray();
        while(i<j){
            if(ch[i]!=ch[j]) return true;
            i++;
            j--;
        }
        return false;
    }


}
