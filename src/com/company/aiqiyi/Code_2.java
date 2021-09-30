package com.company.aiqiyi;

import java.util.*;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] ch = s.toCharArray();
        List<List<Integer>> input = new ArrayList<>();
        for(int i = 1;i<ch.length-1;i++){
            List<Integer> temp = new ArrayList<>();
            if(ch[i]=='['){
                temp.add(ch[i + 1]-'0');
                temp.add(ch[i + 3]-'0');
                input.add(temp);
            }
        }
        if(input.size()==0) System.out.println(0);
        int result = remove(input);
        System.out.println(result);
    }

    private static int remove(List<List<Integer>> input) {
        Collections.sort(input, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                return integers.get(1)-t1.get(1);
            }
        });
        int count = 1;
        int right = input.get(0).get(1);
        for(int i=1;i<input.size();i++){
            if(input.get(i).get(0)>=right){
                count++;
                right=input.get(i).get(1);
            }
        }
        return input.size()-count;

    }

}
