package com.company.nanobank;

import java.util.*;

public class Code_2 {
    public static void main(String[] args){
        String[][] a ={{"johnsmith@mail.com","john00@mail.com","John"},
                {"johnnybravo@mail.com","John"},
                {"johnsmith@mail.com","john_newyork@mail.com","John"},
                {"mary@mail.com","Mary"}};
        String[][] result = accountsMerge(a);
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                System.out.println(result[i][j]);
            }
        }
    }
    public static String[][] accountsMerge (String[][] accounts) {
        // write code here
        List<String[]> result = new ArrayList<>();
        boolean[] used = new boolean[accounts.length];
        for(int i = 0;i<accounts.length;i++){
            if(used[i]) continue;
            String[] temp = accounts[i];
            for(int j = 1;j<accounts.length;j++){
                if(isValid(temp,accounts[j])){
                    temp = merge(temp,accounts[j]);
                    used[j] = true;
                }
            }
            result.add(temp);
        }
        Collections.sort(result, new Comparator<String[]>() {
            @Override
            public int compare(String[] strings, String[] t1) {
                return strings[0].compareTo(t1[0]);
            }
        });
        String[][] finalResult = new String[result.size()][];
        for(int i = 0;i<result.size();i++){
            finalResult[i] =result.get(i);
        }
        return finalResult;
    }
    public static boolean isValid(String[] a, String[] b){
        for(int i =0;i<a.length-1;i++){
            for(int j = 0;j<b.length-1;j++){
                if(a[i].equals(b[j])) return true;
            }
        }
        return false;
    }
    public static String[] merge(String[] a,String[] b){
        HashSet<String> result = new HashSet<>();
        for(int i = 0;i<a.length-1;i++){
            result.add(a[i]);
        }
        for(int i = 0;i<b.length-1;i++){
            result.add(b[i]);
        }
        String[] temp = new String[result.size()];
        int i =0;
        for(String s: result){
            temp[i] = s;
            i++;
        }
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        String[] finalResult = new String[temp.length+1];
        for(int j = 0;j<temp.length;j++){
            finalResult[j] = temp[j];
        }
        finalResult[finalResult.length-1] = a[a.length-1];
        return finalResult;

    }
}
