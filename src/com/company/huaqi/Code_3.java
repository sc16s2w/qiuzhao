package com.company.huaqi;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public class Code_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String result = calculate(s);
        System.out.println(result);
    }

    private static String calculate(String s) {
        Stack<Character> store =  new Stack<>();
        String result = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==']') {
                char alpha = store.pop();
                while (!isAlphabetic(alpha)) {
                    alpha = store.pop();
                }
                char digit = store.pop();
                while (!isDigit(digit)) {
                    digit = store.pop();
                }
                String st = result+alpha;
                String te = digit+"";
                int di = Integer.valueOf(te);
                result="";
                while (di > 0) {
                    result +=st;
                    di--;
                }
            }
            store.add(c);
            }
        String finalResult = "";
        for(int i =result.length()-1;i>=0;i--){
            finalResult+=result.charAt(i);
        }

        return finalResult;
        }

}
