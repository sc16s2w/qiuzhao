package com.company.tusenweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String input = scanner.next();
        char[][] res = calcluate(num,input);
        for(int i =0;i<res.length;i++){
            String t ="";
            for(int j = 0;j<res[i].length;j++){
                t+=res[i][j];
            }
            System.out.println(t);
        }

    }

    private static char[][] calcluate(int num, String input) {
        int sum = 0;
        List<Integer> res= new ArrayList<>();
        char[] ch = input.toCharArray();
        for(int i =0;i<ch.length;i++){
            if(ch[i]=='+'){
                res.add(sum);
                sum +=1;
            }
            else if(ch[i]=='-'){
                sum-=1;
                res.add(sum);
            }
            else{
                res.add(sum);
            }
        }
        int max = Collections.max(res);
        int min = Collections.min(res);
        if(min>0) min =0;
        char[][] result = new char[max-min+1][num];
        for(int i =0;i<result.length;i++){
            for(int j =0;j<result[i].length;j++){
                result[i][j]='.';
            }
        }
        int count = 0;
        for(int i =0;i<ch.length;i++){
            System.out.println(ch[i]+" "+(max-count));
            if(ch[i]=='+'){
                result[max-count][i] = '/';
                count +=1;

            }
            else if(ch[i]=='-'){
                count -=1;
                result[max-count][i] = '\\';
            }
            else{
//                System.out.println(max-count);
                result[max-count][i] = '-';
            }
        }
        return result;

    }
}
