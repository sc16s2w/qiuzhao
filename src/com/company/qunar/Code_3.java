package com.company.qunar;

import java.util.HashSet;
import java.util.Set;

public class Code_3 {
    public static void main(String[] args){

        System.out.println(solution("cdcdsdcdscbaabc"));
    }
    static StringBuilder sb = new StringBuilder();
    static Set<String> result = new HashSet<>();
    public static int solution(String str) {
        char[] ch = str.toCharArray();
        retrace(ch,0);
//        for(String s: result){
//            System.out.println(s);
//        }
        return result.size();

    }
    public static void retrace(char[] ch,int index){
        if(judge(sb.toString())){
            result.add(sb.toString());
        }
        if(sb.length()==ch.length) return;
        for(int i = index;i<ch.length;i++){
            if(sb.length()!=0&&i>index) break;
            sb.append(ch[i]);
            retrace(ch,i+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public static boolean judge(String str){
        if(str.length()%3!=1) return false;
        int n =str.length()/3+1;
        if(n<2) return false;
        for(int i = 0;i<str.length();i++){
            int t =i+1;
            if(((2*n+t-3)>str.length()-1)||(2*n-t-1>str.length()-1)) break;
            if(str.charAt(t-1) != str.charAt(2*n-t-1)) return false;
            if(str.charAt(2*n-t-1) != str.charAt(2*n+t-3)) return false;
            if(str.charAt(t-1) != str.charAt(2*n+t-3)) return false;
        }
        return true;
    }
}
