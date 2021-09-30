package com.company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code_1 {
    public static int calculate(List<Integer> red,List<Integer> blue,int k){
        int result = 0;
        boolean[] used = new boolean[blue.size()];
        for(int i =0;i<red.size();i++){
            for(int j =0;j<blue.size();j++){
                if(Math.abs(red.get(i)-blue.get(j))<=k&&!used[j]){
                    System.out.println(red.get(i)+" "+ blue.get(j));
                    used[j]=true;
                    result++;
                    break;
                }
            }

        }
        return result;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        while(num!=0){
            int redNum = scanner.nextInt();
            int blueNum = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> red = new ArrayList<>();
            List<Integer> blue = new ArrayList<>();
            for(int i = 0;i<redNum;i++){
                red.add(scanner.nextInt());
            }
            for(int i = 0;i<blueNum;i++){
                blue.add(scanner.nextInt());
            }
            result.add(calculate(red,blue,k));
            num--;
        }
        for(Integer re:result){
            System.out.println(re);
        }
    }
}
