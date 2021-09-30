package com.company.tusenweilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code_3 {
    static List<String> t = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();
        List<String> store = new ArrayList<>();
        for(int i = 0;i<num;i++){
            store.add(scanner.next());
        }
        System.out.println(calculate(store,k));
//        List<String> temp = new ArrayList<>();
//        temp.add("ovo");
//        temp.add("ono");
//        temp.add("voo");
//        System.out.println(judge(temp,1));
    }
    private static int calculate(List<String> store, int k) {
        dfs(0,store,k);
        return count;
    }

    private static void dfs(int cur, List<String> store,int k) {
        int mod = (int) (Math.pow(10,9)+7);
        if(cur==store.size()){
//            System.out.println(t.toString());
//            System.out.println(judge(t,k));
            if(judge(t,k)) count = (int) ((count++)%mod);
            return;
        }
        t.add(store.get(cur));
        dfs(cur+1,store,k);
        t.remove(t.size()-1);
        dfs(cur+1,store,k);
    }

    private static boolean judge(List<String> t,int k) {
        int tempK = 0;
        if(t.size()<1) return false;
        for(int j =0;j<t.size()-1;j++){
            String s = t.get(j);
            for(int m = j+1;m<t.size();m++){
                int[] ch = new int[26];
                for(int i =0;i<s.length();i++){
//                    System.out.println(s);
//                    System.out.println(s.charAt(i)-'a');
                    ch[s.charAt(i)-'a']++;
                }
                String ts = t.get(m);
                for(int n =0;n<ts.length();n++){
                    ch[ts.charAt(n)-'a']--;
                }
                boolean res = true;
                for(int i = 0;i<26;i++){
                    if(ch[i]!=0) res =false;
                }
                if(res) tempK++;
            }
        }
//        System.out.println(tempK);
        if(tempK==k) return true;
        return false;
    }
}
