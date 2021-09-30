package com.company.huawei;

import java.util.*;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        String[] temp1 =s.split(" ");
        String[] temp2 =t.split(" ");
        int[] input1 = new int[temp1.length];
        int[] input2 = new int[temp2.length];
        for(int i = 0;i<temp1.length;i++){
            input1[i] = Integer.parseInt(temp1[i]);
        }
        for(int i = 0;i<temp2.length;i++){
            input2[i] = Integer.parseInt(temp2[i]);
        }
        Arrays.sort(input1);
        Arrays.sort(input2);
        int result = getRadius(input1,input2);
        System.out.println(result);
    }

    private static int getRadius(int[] input1, int[] input2) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<input1.length;i++){
            int temp =Integer.MAX_VALUE;
            for(int j = 0;j<input2.length;j++){
                temp = Math.min(temp,Math.abs(input2[j]-input1[i]));
            }
            result.add(temp);
        }
        return Collections.max(result);
    }
}
