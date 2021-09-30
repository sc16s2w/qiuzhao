package com.company.qunar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Code_1 {
    public static void main(String[] args){
        int[] input = new int[]{3,6,7};
        String s = "";
        System.out.println(s);
        System.out.println(solution(input));

    }
    static LinkedList<Integer> temp = new LinkedList<>();
    static List<List<Integer>> store = new ArrayList<>();
    public static String solution(int[] d) {
        rerace(d,0,0);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> t:store){
            result.add(calculate(t));
        }
        return Collections.max(result).toString();
    }
    public static void rerace(int[] d, int index,int sum){
        if(sum%3==0){
            store.add(new ArrayList<>(temp));
        }
        if(index == d.length) return;
        for(int i = index;i<d.length;i++){
            temp.add(d[i]);
            sum = sum+d[i];
            rerace(d,i+1,sum);
            sum = sum - d[i];
            temp.removeLast();
        }
    }
    public static int calculate(List<Integer> temp){
        Collections.sort(temp);
        int res = 0;
        for(int i = 0;i<temp.size();i++){
            res+=temp.get(i)*Math.pow(10,i);
        }
        return res;
    }
}
