package com.company.shence;

import java.util.*;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<int[]> result = calculate(input);
        System.out.println(result.size());
        for(int i =0;i<result.size();i++){
            System.out.println(result.get(i)[0]);
            System.out.println(result.get(i)[1]);
        }
    }

    private static List<int[]> calculate(String input) {
        String[] store = input.split("");
        Stack<Integer> temp = new Stack<>();
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<store.length;i++){
            if(store[i].equals("(")) temp.add(i);
            else if(store[i].equals(")")){
                result.add(new int[]{temp.pop(),i});
            }
        }
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        return result;
    }
}
